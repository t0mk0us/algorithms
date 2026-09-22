package tomkous.algos.ms;

import java.util.Random;

public class MarketMaker {

    // Configuration constants
    private static final double DESIRED_SPREAD = 0.02; // 2% total spread
    private static final int TARGET_INVENTORY = 0;     // Ideal inventory position
    private static final double INVENTORY_RISK_FACTOR = 0.005; // Price adjustment per unit of imbalance

    // Simulated market state
    private double currentMidPrice = 100.00;
    private int currentInventory = 0; // Negative = short, Positive = long
    private final Random random = new Random();

    public static void main(String[] args) {
        MarketMaker engine = new MarketMaker();
        engine.runSimulation(10); // Run for 10 simulated market cycles
    }

    /**
     * Simulates a live market loop where the mid-price moves and orders are filled.
     */
    public void runSimulation(int cycles) {
        System.out.println("Starting Java Market-Making Simulation...");
        System.out.println("Format: [Cycle] Mid Price | Bid (Buy) | Ask (Sell) | Inventory | Action");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 1; i <= cycles; i++) {
            // 1. Simulate external market price movement (Random Walk)
            double priceChange = (random.nextDouble() - 0.5) * 2.0; // Random change between -1.0 and +1.0
            currentMidPrice = Math.round((currentMidPrice + priceChange) * 100.0) / 100.0;

            // 2. Calculate quoting prices based on inventory risk management
            Quote currentQuote = calculateQuotes();

            // 3. Simulate order execution from random external traders
            String actionTaken = simulateOrderExecution(currentQuote);

            // 4. Log the state of the market maker
            System.out.printf("[%02d] Mid: $%.2f | Bid: $%.2f | Ask: $%.2f | Inv: %d | %s%n",
                    i, currentMidPrice, currentQuote.bidPrice, currentQuote.askPrice, currentInventory, actionTaken);

            // Brief pause to simulate time passing between blocks/ticks
            try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    /**
     * Calculates the bid and ask quotes. 
     * Skews prices lower if inventory is high (to discourage buying and encourage selling).
     */
    private Quote calculateQuotes() {
        // Calculate inventory imbalance relative to our target
        int inventoryImbalance = currentInventory - TARGET_INVENTORY;

        // Shift the reference price to manage inventory risk
        double inventoryShift = inventoryImbalance * INVENTORY_RISK_FACTOR * currentMidPrice;
        double reservationPrice = currentMidPrice - inventoryShift;

        // Apply symmetric spread around the shifted reservation price
        double halfSpread = (currentMidPrice * DESIRED_SPREAD) / 2.0;
        
        double bid = Math.round((reservationPrice - halfSpread) * 100.0) / 100.0;
        double ask = Math.round((reservationPrice + halfSpread) * 100.0) / 100.0;

        return new Quote(bid, ask);
    }

    /**
     * Simulates random external order flow hitting our posted quotes.
     */
    private String simulateOrderExecution(Quote quote) {
        int chance = random.nextInt(100);

        if (chance < 35) {
            // Someone sells to our Bid
            currentInventory++;
            return "FILLED BUY (Asset Bought at $" + quote.bidPrice + ")";
        } else if (chance < 70) {
            // Someone buys from our Ask
            currentInventory--;
            return "FILLED SELL (Asset Sold at $" + quote.askPrice + ")";
        } else {
            // No orders matched our spread during this cycle
            return "NO FILL (Spread maintained)";
        }
    }

    /**
     * Data container class for nested quote structures.
     */
    private static class Quote {
        final double bidPrice;
        final double askPrice;

        Quote(double bidPrice, double askPrice) {
            this.bidPrice = bidPrice;
            this.askPrice = askPrice;
        }
    }
}

