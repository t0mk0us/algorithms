package tomkous.algos.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {
	
	public static int solution(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < A.length; i++) {
			
			set.add(A[i]);
		}
		
		return set.size();
	}
	
	public static void main(String[] args) {
		
		int[] array1 = {1, 2, 3, 4, 5, 6, 1, 1, 1, 1, 2};
		
		System.out.println("There are " + solution(array1) + " distinct values in " + Arrays.toString(array1));
	}

}
