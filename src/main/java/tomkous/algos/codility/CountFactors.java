package tomkous.algos.codility;

import java.util.ArrayList;
import java.util.List;

public class CountFactors {
	
	public static int solution(int N) {
		
		int count = 2; //There is always at least one factor - 1
		List<Long> factors = new ArrayList<Long>();
		
		if (N == 1)
			return 1;
		else
			for(long i = 2; i * i <= N; i++) {
				
				if (N % i == 0) {
					
					factors.add(i);
					count++;
					
					if (i != N/i) {
						
						factors.add(N/i);
						count++;
					}
				}
			}
		
		return count;
	}; 

	public static void main (String args[]) {
		
		System.out.println("There are " + solution(1) + " factors of 1");
		System.out.println("There are " + solution(9) + " factors of 9");
		System.out.println("There are " + solution(7) + " factors of 7");
		System.out.println("There are " + solution(21) + " factors of 21");
		System.out.println("There are " + solution(24) + " factors of 24");
		System.out.println("There are " + solution(999999) + " factors of 999,999");
		System.out.println("There are " + solution(2147483647) + " factors of 2,147,483,647");
		System.out.println("There are " + solution(2147483646) + " factors of 2,147,483,646");
		
		for (int i = 1; i < 10; i++) {
			
			System.out.println("There are " + solution(i) + " factors of " + i);
		}
	}
}
