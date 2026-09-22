package tomkous.algos.codility;

import java.util.HashSet;

public class OddOccurenciesInArray {

	public static int solution(int[] A) {
		
		HashSet<Integer> present = new HashSet<Integer>();
		HashSet<Integer> paired = new HashSet<Integer>();
		
		if (A.length % 2 == 0 || A.length == 0)
			return 0;
		else if (A.length == 1)
			return A[0];
		
		else {
		
			for (int num : A) {
							
				if (!present.add(num)) {	
					
					paired.add(num);
					
				} 				
			}
		}
		present.removeAll(paired);
		if  (present.isEmpty())
			return 0;
		else			
			return present.iterator().next();
	};
	
	public static void main(String args[]) {
		
		int[] array1 = {9, 3, 9, 3, 9, 7, 9};
		int[] array2 = {1, 999_999_999, 3_000_333, 5, 999_999_999, 5,  1, 21, 3_000_333};
		int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] array4 = {21, 25, 34, 1_000_000_000, 4_444_555, 34, 4_444_555, 777_999, 25, 21, 777_999};
		int[] array5 = {1_000_000_000, 4_444_555, 777_999, 345_567, 4_444_555, 345_567, 1_000_000_000, 777_999};
		int[] array6 = {};
		
		System.out.println("Unpaired int in [9, 3, 9, 3, 9, 7, 9] is " + solution(array1));
		System.out.println("Unpaired int in [1, 999_999_999, 3_000_333, 5, 999_999_999, 5,  1, 21, 3_000_333] is " + solution(array2));
		System.out.println("Unpaired int in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1] is " + solution(array3));
		System.out.println("Unpaired int in [21, 25, 34, 1_000_000_000, 4_444_555, 34, 4_444_555, 777_999, 25, 21, 777_999] is " + solution(array4));
		System.out.println("Unpaired int in [] is " + solution(array5));
		System.out.println("Unpaired int in [] is " + solution(array6));
	}
}
