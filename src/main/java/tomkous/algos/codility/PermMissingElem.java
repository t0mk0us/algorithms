package tomkous.algos.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PermMissingElem {

	 public static int solution(int[] A) {
	        int xorSum = 0;
	        int N = A.length;

	        if (A.length == 1)
	        	if (A[0] == 0)
	        		return 1;
	        
	        // 1. XOR all numbers that *should* be in the range: 1 to (N + 1)
	        for (int i = 1; i <= N + 1; i++) {
	            xorSum ^= i;
	        }

	        // 2. XOR all elements that are *actually* present in the array
	        for (int num : A) {
	            xorSum ^= num;
	        }

	        // 3. Elements present in both steps cancel out to 0.
	        // Only the missing number remains.
	        return xorSum;
	    }
	
	//Helper function Creat an Array of N elements in the range [1...(N + 1)]
	public static int[] createArray(int N, int omit) {
		
		int[] newArray = new int[N];
		
		for (int i = 0; i < omit-1 && i < N-1; i++) {
			
				newArray[i] = i+1;
				//System.out.println("Added " + (i+1));
		}
		for (int i = omit-1; i < N; i++) {
			
			newArray[i] = i+2;
		}
		//System.out.println("Created " + Arrays.toString(newArray));
		
		shuffle(newArray);
		
		return newArray;
	}
	
	public static void shuffle(int[] array) {
        Random rand = new Random();
        
        // Loop backwards from the last element down to the second element
        for (int i = array.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = rand.nextInt(i + 1);
            
            // Swap array[i] with the element at the random index j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
	
	public static void main(String[] args) {
		
		int[] array1 = createArray(10, 11);
		int[] array2 = createArray(100_000, 100099);
		int[] array5 = createArray(100, 63);
		int[] array3 = createArray(1, 1);
		int[] array4 = {};
		int[] array6 = {0};
		
		System.out.println("Missing number in array1 " + Arrays.toString(array1) + " is " + solution(array1));
		System.out.println("Missing number in array2 " + Arrays.toString(array2) + " is " + solution(array2));
		System.out.println("Missing number in array3 " + Arrays.toString(array3) + " is " + solution(array3));
		System.out.println("Missing number in array4 " + Arrays.toString(array4) + " is " + solution(array4));
		System.out.println("Missing number in array5 " + Arrays.toString(array5) + " is " + solution(array5));
		System.out.println("Missing number in array6 " + Arrays.toString(array6) + " is " + solution(array6));
	}
}
