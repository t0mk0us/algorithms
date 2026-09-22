package tomkous.algos.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassingCars {

	    public static int solution(int[] A) {
	        int eastCars = 0;
	        long passingPairs = 0; // Using long to safely check for overflow

	        for (int car : A) {
	            if (car == 0) {
	                // Count how many eastbound cars are currently traveling
	                eastCars++;
	            } else {
	                // A westbound car passes ALL eastbound cars that came before it
	                passingPairs += eastCars;
	                
	                // Check the limit threshold constraint immediately
	                if (passingPairs > 1_000_000_000) {
	                    return -1;
	                }
	            }
	        }

	        return (int) passingPairs;
	    }

	public static void main(String[] args) {
		
		int[] array1 = {0, 1, 0, 1, 1};
		int[] array2 = {0};
		int[] array3 = {1};
		int[] array4 = {};
		int[] array5 = {0, 1};
		int[] array6 = {0, 0};
		int[] array7 = {1, 1};
		int[] array9 = {0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
				1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 
				1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 
				1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
				1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
				1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		System.out.println("There are " + solution(array1) + " car pairs n the array " + Arrays.toString(array1));
		System.out.println("There are " + solution(array2) + " car pairs n the array " + Arrays.toString(array2));
		System.out.println("There are " + solution(array3) + " car pairs n the array " + Arrays.toString(array3));
		System.out.println("There are " + solution(array4) + " car pairs n the array " + Arrays.toString(array4));
		System.out.println("There are " + solution(array5) + " car pairs n the array " + Arrays.toString(array5));
		System.out.println("There are " + solution(array6) + " car pairs n the array " + Arrays.toString(array6));
		System.out.println("There are " + solution(array7) + " car pairs n the array " + Arrays.toString(array7));
		System.out.println("There are " + solution(array9) + " car pairs n the array " + Arrays.toString(array9));
	}

}
