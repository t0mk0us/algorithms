 package tomkous.algos.codility;

import java.util.Arrays;

public class CyclicRotation {

	 public static int[] solution(int[] A, int K) {
		 
		 int[] result = A;
		 //System.out.println("At start result is " + Arrays.toString(result));
		 
		 if (A.length == 0)
			 return A;
		 
		 else {
			 for (int j = 0; j < K; j++) {
				 
				 result = rotate(result);
				 //System.out.println("result after rotation " + j + " is " + Arrays.toString(result));
			 }
		 }
		 
		 return result;
	 };
	 
	 static int[] rotate(int[] A) {
		 
		 int[] result = A;
		 int last = A[A.length-1];
		 
		 for (int i = 1; i < A.length; i++) {
			 //System.out.println("result[A.length - i] = " + result[A.length - i]);
			 //System.out.println("result[A.length - i-1] = " + result[A.length - i-1]);
			 
			 result[A.length - i] = A[A.length - i - 1];
			//System.out.println("result in rotate at step " + i + " is " + Arrays.toString(result));
		 }
		 
		 result[0] = last; 
		 
		 return result;
	 }
	 
	 public static void main(String args[]) {
		 
		 int[] array1 = {3, 8, 9, 7, 6};
		 int[] array2 = {0, 0, 0};
		 int[] array3 = {1, 2, 3, 4};
		 //extreme_empty test
		 int[] array4 = {};
		 
		 System.out.println("3 Rotations of [3, 8, 9, 6] gives " +  Arrays.toString(solution(array1, 3)));
		 System.out.println("1 Rotation of [0, 0, 0] gives " +  Arrays.toString(solution(array2, 1)));
		 System.out.println("4 Rotations of [1, 2, 3, 4] gives " +  Arrays.toString(solution(array3, 4)));
		 System.out.println("2 Rotations of an empty array [] gives " +  Arrays.toString(solution(array4, 2)));
	 }
}
