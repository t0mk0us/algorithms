package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ParallelRiskEngine {

    public record BondPosition(String isin, String bookId, long notional) {}
    public record RiskResult(String isin, double dv01, double pvbp) {}
    
//    public static void main(String[] args) {
//    	
//    	List<BondPosition> pos = new ArrayList<BondPosition>();
//    	
//    	pos.add(new BondPosition("Book1", "ABC", 10000));
//		pos.add(new BondPosition("Book1", "BCD", 20000));
//		pos.add(new BondPosition("Book1", "CDE", 30000));
//		pos.add(new BondPosition("Book1", "DEF", 35000));
//		pos.add(new BondPosition("Book1", "FGI", 24000));
//		pos.add(new BondPosition("Book1", "GIJ", 50000));
//		pos.add(new BondPosition("Book1", "IJK", 60000));
//		pos.add(new BondPosition("Book1", "KLM", 70000));
//		pos.add(new BondPosition("Book1", "LMN", 80000));
//		pos.add(new BondPosition("Book1", "MNO", 90000));
//		pos.add(new BondPosition("Book1", "NOP", 100000));
//		pos.add(new BondPosition("Book1", "OPR", 110000));
//		
//		evaluatePortfolioRisk(pos);
//    }

    // Bounded, dedicated resource pool to isolate heavy CPU/risk work
    private final ForkJoinPool riskThreadPool = new ForkJoinPool(
        Runtime.getRuntime().availableProcessors(),
        ForkJoinPool.defaultForkJoinWorkerThreadFactory,
        null, 
        true // Async mode optimized for fine-grained tasks
    );

    /**
     * Executes risk evaluation across thousands of positions concurrently in a controlled pool.
     */
    public Map<String, RiskResult> evaluatePortfolioRisk(List<BondPosition> positions) {
        if (positions == null || positions.isEmpty()) {
            return Map.of();
        }

        try {
            // Submit the entire pipeline to the custom ForkJoinPool to prevent commonPool starvation
            return riskThreadPool.submit(() -> 
                positions.parallelStream()
                    .map(this::computePositionRisk)
                    .collect(Collectors.toConcurrentMap(RiskResult::isin, result -> result))
            ).get(); // Block caller thread only for the final aggregation pass

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Risk engine processing was interrupted or failed", e);
        }
    }

    /**
     * Heavy mathematical calculation simulating yield curve interpolation and matrix multiplication.
     */
    private RiskResult computePositionRisk(BondPosition position) {
        // Simulate computation latency without calling Thread.sleep()
        // In reality, this would query a lock-free YieldCurve cache
        double mockDv01 = position.notional() * 0.00045;
        double mockPvbp = position.notional() * 0.00042;
        return new RiskResult(position.isin(), mockDv01, mockPvbp);
    }

    public void shutdown() {
        riskThreadPool.shutdown();
    }
}

