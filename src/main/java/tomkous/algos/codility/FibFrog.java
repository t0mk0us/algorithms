package tomkous.algos.codility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FibFrog {

	public static int solution(int[] A) {
		
		int jumps = 0;
		
		List<Integer> leafs = new ArrayList<>();

		int[] startEndAdded = new int[A.length + 2];
		
		startEndAdded[0] = 1;
		
		System.arraycopy(A, 0, startEndAdded, 1, A.length);
		
		startEndAdded[startEndAdded.length - 1] = 1;			
		
		List<Long> fibPairs = findFibonacciPairs(startEndAdded);
		
		jumps = findMinJumps(fibPairs, startEndAdded.length);
		
		return jumps;
	}	
	
	public static long packPair(int index1, int index2) {
        return ((long) index1 << 32) | (index2 & 0xFFFFFFFFL);
    }

    public static List<Long> findFibonacciPairs(int[] A) {
        List<Long> results = new ArrayList<>();
        int N = A.length;

        // 1. Precompute Fibonacci numbers up to N (max 100,000)
        // There are at most 26 Fibonacci numbers under 100,000
        List<Integer> fibs = new ArrayList<>();
        int a = 1;
        int b = 2;
        fibs.add(1); // First valid step distance
        while (b < N) {
            fibs.add(b);
            int next = a + b;
            a = b;
            b = next;
        }

        // 2. Track indices of all 1s for fast sequential processing
        // Also gives us O(1) verification via the original array A
        for (int i = 0; i < N; i++) {
            if (A[i] != 1) continue;

            // 3. For every '1', test only the 25 possible Fibonacci step distances
            for (int fib : fibs) {
                int targetIndex = i + fib;

                // Stop if the step overshoots the array bounds
                if (targetIndex >= N) {
                    break; 
                }

                // If the target index also contains a 1, we found our pair!
                if (A[targetIndex] == 1) {
                    results.add(packPair(i, targetIndex));
                }
            }
        }

        return results;
    }
	    
//	public static List<Integer> getFibonacciUpTo(long N) {
//		   
//        List<Integer> suite = new ArrayList<>();
//        
//        // Edge case: If N is negative, return an empty sequence
//        if (N < 0) {
//            return suite;
//        }
//        
//        // Initialize the first two Fibonacci numbers
//        int a = 0;
//        int b = 1;
//        
//        // Loop while the current number is less than or equal to N
//        while (a <= N) {
//            suite.add(a);
//            
//            // Compute the next Fibonacci number
//            int next = a + b;
//            a = b;
//            b = next;
//        }
//        
//        return suite;
//	}
	
	private static class Node {
        int index;
        int jumps;

        Node(int index, int jumps) {
            this.index = index;
            this.jumps = jumps;
        }
    }

    public static int findMinJumps(List<Long> packedPairs, int totalElements) {
        int startNode = 0;
        int targetNode = totalElements - 1;

        // 1. Build an optimized Adjacency List
        // The array size is totalElements (up to 100,000)
        List<Integer>[] graph = new ArrayList[totalElements];
        for (int i = 0; i < totalElements; i++) {
            graph[i] = new ArrayList<>();
        }

        // Unpack your longs into the graph structure
        for (long packed : packedPairs) {
            int u = (int) (packed >> 32); // Source index
            int v = (int) packed;         // Destination index
            graph[u].add(v);
        }

        // 2. Standard BFS Queue Initialization
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[totalElements];

        // Start at index 0 with 0 jumps completed
        queue.add(new Node(startNode, 0));
        visited[startNode] = true;

        // 3. Process the nodes level by level
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // If we've successfully landed on the last index, return the jump count!
            if (current.index == targetNode) {
                return current.jumps;
            }

            // Look at all available forward jumps from the current position
            for (int nextIndex : graph[current.index]) {
                if (!visited[nextIndex]) {
                    visited[nextIndex] = true;
                    queue.add(new Node(nextIndex, current.jumps + 1));
                }
            }
        }

        // If the queue empties and we never reached targetNode, a path is mathematically impossible
        return -1; 
    }

    public static void main(String[] args) {
        long N = 11;
       // List<Integer> result = getFibonacciUpTo(N);
        int[] A = {1, 0 , 1, 1, 0, 1, 0, 0, 1, 0};
        int[] A1 = {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1};
        int[] A2 = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        
        List<Long> packedPairs = findFibonacciPairs(A);
        
        System.out.println("Found " + packedPairs.size() + " valid pairs:");
        for (long packed : packedPairs) {
            int idx1 = (int) (packed >> 32);
            int idx2 = (int) packed;
            System.out.println("Pair: (" + idx1 + ", " + idx2 + ") -> Distance: " + (idx2 - idx1));    
        }
        
        List<Long> packedPairs1 = findFibonacciPairs(A1);
        
        System.out.println("For A1 Found " + packedPairs.size() + " valid pairs:");
        for (long packed : packedPairs1) {
            int idx1 = (int) (packed >> 32);
            int idx2 = (int) packed;
            System.out.println("Pair: (" + idx1 + ", " + idx2 + ") -> Distance: " + (idx2 - idx1));    
            System.out.println("The minimal number of jumps through original A2 is " + solution(A2));
        }
    }
}
