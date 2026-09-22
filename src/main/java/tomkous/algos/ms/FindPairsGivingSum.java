package tomkous.algos.ms;

import java.util.HashSet;

public class FindPairsGivingSum {

    public static void main(String[] args) {
        int[] intArray = {4, 6, 2, 3, 8, 1, 9, 5};
        int sum = 7;
        
        findPairsWithHashSet(intArray, sum);
    }

    public static void findPairsWithHashSet(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        
        System.out.println("Pairs using HashSet:");
        for (int num : arr) {
            int complement = target - num;
            
            if (seenNumbers.contains(complement)) {
                System.out.println("(" + num + ", " + complement + ")");
            }
            seenNumbers.add(num);
        }
    }
}
