package tomkous.algos.ms;

public class HighestFixedIncome {

    public static FixedIncomeAsset findMaxYield(FixedIncomeAsset[] arr) {
        if (arr == null || arr.length != 5) {
            throw new IllegalArgumentException("Array must contain exactly 5 elements.");
        }

        FixedIncomeAsset highest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].yield > highest.yield) {
                highest = arr[i];
            }
        }
        return highest;
    }

	static class FixedIncomeAsset {
	    String name;
	    double yield;
	
	    FixedIncomeAsset(String name, double yield) {
	        this.name = name;
	        this.yield = yield;
	    	}
		}
	
    public static void main(String[] args) {
        // Sample array of 5 fixed-income assets
        FixedIncomeAsset[] assets = {
            new FixedIncomeAsset("1-Year Treasury Bond", 4.25),
            new FixedIncomeAsset("2-Year Bank GIC", 4.50),
            new FixedIncomeAsset("5-Year Corporate Bond", 5.15),
            new FixedIncomeAsset("High-Yield 18-Mo CD", 4.85),
            new FixedIncomeAsset("3-Month T-Bill", 4.10)
        };

        FixedIncomeAsset mostProfitable = findMaxYield(assets);
        System.out.println("Most Profitable: " + mostProfitable.name + " (" + mostProfitable.yield + "%)");
    }
}
