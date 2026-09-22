package tomkous.algos.codility;

import java.util.Arrays;

public class PermCheck {
	
	public static int solution(int[] A) {
		
        int xorSum = 0;
        int N = A.length;

        if (A.length == 1)
        	if (A[0] == 1)
        		return 1;
        	else
        		return 0;
        
        if (A.length == 0)
        	return 0;
        
        // 1. XOR all numbers that *should* be in the range: 1 to (N + 1)
        for (int i = 1; i <= N; i++) {
            xorSum ^= i;
        }

        // 2. XOR all elements that are *actually* present in the array
        for (int num : A) {
            xorSum ^= num;
        }

        System.out.println("xorSum is " + xorSum);
        // 3. Elements present in both steps cancel out to 0.
        // Only the missing number remains.
        if (xorSum == 0)
        	return 1;
        else
        	return 0;
	}

	public static void main(String[] args) {
		
		int[] array4 = {4, 1, 3, 2};
		int[] array6 = {4, 1, 3};
		
		System.out.println("Array " + Arrays.toString(array4) + " is " + solution(array4));
		System.out.println("Array " + Arrays.toString(array6) + " is " + solution(array6));
	}
}
