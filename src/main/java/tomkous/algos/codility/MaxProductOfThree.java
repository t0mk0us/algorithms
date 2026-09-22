package tomkous.algos.codility;

import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {
        // 1. Sort the array in ascending order
        Arrays.sort(A);
        
        int n = A.length;
        
        // Scenario 1: Product of the three largest numbers
        int product1 = A[n - 1] * A[n - 2] * A[n - 3];
        
        // Scenario 2: Product of the two smallest (negative) numbers and the largest number
        int product2 = A[0] * A[1] * A[n - 1];
        
        // Return the maximum of the two possibilities
        return Math.max(product1, product2);
    }
}
