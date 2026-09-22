package tomkous.algos.ms;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class RfqTimeoutManager {

    public record RfqRequest(String rfqId, String isin, long quantity) {}
    public record Quote(String rfqId, double price, String status) {}

    // Single background thread managing exclusively timeout triggers
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "rfq-timeout-scheduler");
        thread.setDaemon(true); // Won't block JVM shutdown
        return thread;
    });

    // Worker pool for executing actual complex pricing models
    private final ExecutorService pricingWorkerPool = Executors.newFixedThreadPool(16);

    /**
     * Ingests an RFQ request, submits it to pricing, and racingly sets a timeout barrier.
     */
    public CompletableFuture<Quote> processRfqWithTimeout(RfqRequest rfq, long timeoutMillis) {
        CompletableFuture<Quote> pricingTask = CompletableFuture.supplyAsync(
            () -> executeComplexPricing(rfq), 
            pricingWorkerPool
        );

        // Schedule a cancellation callback to execute if the timeout threshold passes first
        ScheduledFuture<?> timeoutTracker = scheduler.schedule(() -> {
            // If completeExceptionally returns true, the pricingTask was successfully aborted by timeout
            boolean timedOut = pricingTask.completeExceptionally(
                new TimeoutException("RFQ " + rfq.rfqId() + " expired after " + timeoutMillis + "ms")
            );
            if (timedOut) {
                handleMarketTimeout(rfq.rfqId());
            }
        }, timeoutMillis, TimeUnit.MILLISECONDS);

        // Clean up step: Ensure the scheduled scheduler task gets cancelled if pricing wins the race
        pricingTask.whenComplete((result, exception) -> timeoutTracker.cancel(false));

        return pricingTask.exceptionally(ex -> {
            // Graceful functional fallback path for UI or downstream routers
            return new Quote(rfq.rfqId(), 0.0, "TIMEOUT_EXPIRED");
        });
    }

    private Quote executeComplexPricing(RfqRequest rfq) {
        try {
            // Simulating variable pricing engine matrix delay
            long artificialDelay = ThreadLocalRandom.current().nextLong(200, 700);
            Thread.sleep(artificialDelay);
            return new Quote(rfq.rfqId(), 99.45, "PRICED_SUCCESSFULLY");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Pricing worker execution interrupted", e);
        }
    }

    private void handleMarketTimeout(String rfqId) {
        // Production log hooks to instantly trigger wire messages rejecting the RFQ back to MarketAxess/Tradeweb
        System.err.printf("[ALARM] RFQ %s breached latency guardrails. Terminated.%n", rfqId);
    }

    public void shutdown() {
        pricingWorkerPool.shutdown();
        scheduler.shutdown();
    }
}

