package tomkous.algos.ms;

public class FindPairsGivingSoomLoops {
	
    public static void main(String[] args) {
        int[] intArray = {4, 6, 2, 3, 8, 1, 9, 5};
        int sum = 7;
        
        findPairsBruteForce(intArray, sum);
    }

    public static void findPairsBruteForce(int[] arr, int target) {
        System.out.println("Pairs using Brute Force:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }
}
