package tomkous.algos.codility;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

import java.util.HashSet;

	public class SmallestMissing {
	    
	    public static int solution(int[] A) {
	        // Step 1: Store all elements of A in a HashSet for O(1) lookups
	        HashSet<Integer> set = new HashSet<>();
	        for (int num : A) {
	            set.add(num);
	        }
	        
	        // Step 2: Look for the smallest positive integer starting from 1
	        int smallestMissing = 1;
	        while (set.contains(smallestMissing)) {
	            smallestMissing++;
	        }
	        
	        return smallestMissing;
	    }
    
    public static void main(String[] args) {
    	
    	int[] set1 = {1, 3, 6, 4, 1, 2};
    	int[] set2 = {1, 2, 3};
    	int[] set3 = {-1, -3};
    	
    	System.out.println("[1, 3, 6, 4, 1, 2] is " + solution(set1));
    	System.out.println("[1, 2, 3] is " + solution(set2));
    	System.out.println("[-1, -3] is " + solution(set3));
    }
}

