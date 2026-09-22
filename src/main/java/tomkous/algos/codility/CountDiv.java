package tomkous.algos.codility;

public class CountDiv {
	
	   public static int solution(int A, int B, int K) {

	        int countB = B / K;
	        
	        int countA = (A == 0) ? 0 : (A - 1) / K;
	        
	        int result = countB - countA;
	        
	        if (A == 0) {
	            result++;
	        }
	        
	        return result;
	    }
	
	public static void main(String[] args) {
		
		int A = 6;
		int B = 11;
		int K = 2;
		
		int A1 = 0;
		int B1 = 1;
		int K1 = 2;
		
		int A2 = 0;
		int B2 = 0;
		int K2 = 2;
		
		int A3 = 6;
		int B3 = 11;
		int K3 = 0;
		
		int A4 = 1;
		int B4 = 51;
		int K4 = 1;
		
		int A5 = 1;
		int B5 = 2_000_000_000;
		int K5 = 3;
		
		System.out.println("There are " + solution(A, B, K) + " numbers divisible by " + K + " within the range from " + A + " to " + B);
		System.out.println("There are " + solution(A1, B1, K1) + " numbers divisible by " + K1 + " within the range from " + A1 + " to " + B1);
		System.out.println("There are " + solution(A2, B2, K2) + " numbers divisible by " + K2 + " within the range from " + A2 + " to " + B2);
		System.out.println("There are " + solution(A3, B3, K3) + " numbers divisible by " + K3 + " within the range from " + A3 + " to " + B3);
		System.out.println("There are " + solution(A4, B4, K4) + " numbers divisible by " + K4 + " within the range from " + A4 + " to " + B4);
		System.out.println("There are " + solution(A5, B5, K5) + " numbers divisible by " + K5 + " within the range from " + A5 + " to " + B5);
	}
}
