package tomkous.algos.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
	
	public static int solution(int X, int[] A) {
		
		int time = -1;
		
		if (X > A.length || A.length == 0)
			return -1;		
		
		Set<Integer> coveredPositions = new HashSet<>();
		
		for (int i=0; i<A.length; i++) {
			
			if (A[i] <= X)
				coveredPositions.add(A[i]);
		
		if (coveredPositions.size() == X)
			return i;
		}
		
		return time;
	}

	 
	 public static void main(String[] args) {
		 
		 int[] array1 = {1, 3, 1, 4, 2, 3, 5, 4};
		 int[] array2 = { 3, 1, 4, 2, 3, 5, 4};
		 int[] array3 = {1, 3, 1, 4, 2, 3, 5, 6};
		 int[] array4 = {1};
		 int[] array5 = {};
		 
		 System.out.println("It takes " + solution(5, array1) + " seconds to jump on the other side");
		 System.out.println("It takes " + solution(5, array2) + " seconds to jump on the other side");
		 System.out.println("It takes " + solution(6, array3) + " seconds to jump on the other side");
		 System.out.println("It takes " + solution(8, array2) + " seconds to jump on the other side");
		 System.out.println("It takes " + solution(1, array4) + " seconds to jump on the other side");
		 System.out.println("It takes " + solution(5, array5) + " seconds to jump on the other side");
		 
	 }
}
