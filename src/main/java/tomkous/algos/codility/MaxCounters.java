package tomkous.algos.codility;

import java.util.Arrays;

public class MaxCounters {
	
		    public static int[] solution(int N, int[] A) {
		        int[] counters = new int[N];
		        
		        int currentMax = 0;   // Tracks the highest counter value achieved so far
		        int lastMaxApplied = 0; // Tracks the "global floor" from the last max_counter operation
		        
		        for (int i = 0; i < A.length; i++) {
		            int operation = A[i];
		            
		            if (operation >= 1 && operation <= N) {
		                int index = operation - 1;
		                
		                // LAZY UPDATE: If this counter hasn't caught up to the last max_counter floor, catch it up now
		                if (counters[index] < lastMaxApplied) {
		                    counters[index] = lastMaxApplied;
		                }
		                
		                // Perform the increase(X) operation
		                counters[index]++;
		                
		                // Dynamically update the current highest value
		                if (counters[index] > currentMax) {
		                    currentMax = counters[index];
		                }
		            } 
		            else if (operation == N + 1) {
		                // DO NOT LOOP HERE. Just record what the new floor should be.
		                lastMaxApplied = currentMax;
		            }
		        }
		        
		        // FINAL PASS: Bring any counters that weren't touched recently up to the final global floor
		        for (int i = 0; i < N; i++) {
		            if (counters[i] < lastMaxApplied) {
		                counters[i] = lastMaxApplied;
		            }
		        }
		        
		        return counters;
		    }
	
	public static void main(String args[]) {
		
		int[] array1 = {3, 4, 4, 6, 1, 4, 4};
		
		System.out.println("The values of the counter after all operations is " + Arrays.toString(solution(5, array1)));
	}
}
