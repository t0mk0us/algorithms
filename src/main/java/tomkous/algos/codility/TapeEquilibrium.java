package tomkous.algos.codility;

import java.util.Arrays;

public class TapeEquilibrium {

	 public static int solution(int[] A) {
		 
		 int minDiff = 0;
		 
		 int first = 0;
		 int second = 0;
		 
		 int sum = 0;
		 
		 for (int num : A) {
			 
			 sum += Math.abs(num);
			 System.out.println("Sum is " + sum);
		 }
		 
		 minDiff = sum;
		 System.out.println("Whole Sum is " + sum);
		 
		 for (int i = 0; i< A.length; i++) {
			 
			 first += Math.abs(A[i]);
			 
			 System.out.println("first is " + first);
			 
			 if (Math.abs(Math.abs(sum) - Math.abs(first * 2)) < minDiff) {
				
				 minDiff =Math.abs(sum - first * 2);
				 
				 System.out.println("minDiff is " + minDiff);
			 }
		 }
		 
		 return minDiff;
	 }
	 
	 public static void main(String[] args) {
		 
		 int[] array = {3, 1, 2, 4, 3};
		 int[] array2 = {-2, -5, -1, -3, -4};
		 
		 System.out.println("The smallest of the split array " + Arrays.toString(array) + " is " + solution(array));
		 System.out.println("The smallest of the split array " + Arrays.toString(array2) + " is " + solution(array2));
	 }
}
