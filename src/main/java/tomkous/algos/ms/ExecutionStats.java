package tomkous.algos.ms;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Stream;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class ExecutionStats {

    public static class Execution {
        private final double executedPrice;
        public Execution(double executedPrice) { this.executedPrice = executedPrice; }
        public double getExecutedPrice() { return executedPrice; }
    }

    public static void main(String[] args) {
        Stream<Execution> executionStream = Stream.of(
            new Execution(100.25),
            new Execution(101.50),
            new Execution(99.75),
            new Execution(100.80)
        );

        // 1. Convert to a primitive DoubleStream to avoid object boxing
        // 2. Collect everything directly using the summary statistics container
        DoubleSummaryStatistics stats = executionStream
            .mapToDouble(Execution::getExecutedPrice)
            .summaryStatistics();

        // Single pass yields all properties instantly
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min Price: " + stats.getMin());
        System.out.println("Max Price: " + stats.getMax());
        System.out.println("Avg Price: " + stats.getAverage());
    }
}

