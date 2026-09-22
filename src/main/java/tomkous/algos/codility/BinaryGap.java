package tomkous.algos.codility;

public class BinaryGap {
	
	public static int solution(int N) {
		
		int lastGap = 0;
		int newGap = 0;
		int binaryGap = 0;
		char last = '2';
		
		String binaryN = Integer.toBinaryString(N);
		
		//System.out.println("Starting processing " + N);
		//System.out.println("Binary representation is " + binaryN);
		
		for (int i = 0; i < binaryN.length(); i++) {
			
			//System.out.println("loop " + i);
			
			if (binaryN.charAt(i) == '0') {
				if (last == '1') {
					if (lastGap == 0) {
						lastGap = 1;
					}
					else {
						newGap = 1;					
					}
					last = '0';
				}
				else if (last == '0') {
					
					if (newGap == 0) {
		
						lastGap++;
						
						//System.out.println("last = " + last);
						//System.out.println("lastGap = " + lastGap);
					}
					else {
						
						newGap++;
						//System.out.println("newGap = " + newGap);
					}
				}
			} else if (binaryN.charAt(i) == '1') {
				
				last = '1';
				
				//System.out.println("last = " + last);
				
				if (newGap > 0) {
					//System.out.println("lastGap = " + lastGap);
					//System.out.println("newGap = " + newGap);
					
					lastGap = Math.max(lastGap, newGap);
					
					//System.out.println("lastGap = " + lastGap);
					//System.out.println("newGap = " + newGap);
					newGap = 0;
				}
			}
		}
		if (last == '1') {
			binaryGap = Math.max(lastGap, newGap);
			
			//System.out.println("lastGap = " + lastGap);
			//System.out.println("newGap = " + newGap);
			//System.out.println("binaryGap = " + binaryGap);
		}	
		else {
			
			if (newGap > 0)
				binaryGap = lastGap;
		}	
			return binaryGap;
	}
	
	public static void main(String[] args) {
		
		System.out.println("BinaryGap of 9 is (binary representations " + Integer.toBinaryString(9) + ") " + solution(9));
		System.out.println("BinaryGap of 529 is (binary representations " + Integer.toBinaryString(529) + ") " + solution(529));
		System.out.println("BinaryGap of 20 is (binary representations " + Integer.toBinaryString(20) + ") " + solution(20));
		System.out.println("BinaryGap of 15 is (binary representations " + Integer.toBinaryString(15) + ") " + solution(15));
		System.out.println("BinaryGap of 1041 is (binary representations " + Integer.toBinaryString(1041) + ") " + solution(1041));
		System.out.println("BinaryGap of 32 is (binary representations " + Integer.toBinaryString(32) + ") " + solution(32));
		System.out.println("BinaryGap of 2,147,483,64 is (binary representations " + Integer.toBinaryString(214748364) + ") " + solution(214748364));	
		System.out.println("BinaryGap of 2,147,483,647 is (binary representations " + Integer.toBinaryString(2147483647) + ") " + solution(2147483647));	
		System.out.println("BinaryGap of 2,147,483,600 is (binary representations " + Integer.toBinaryString(2147483600) + ") " + solution(2147483600));	
		
		System.out.println("BinaryGap of 328 is (binary representations " + Integer.toBinaryString(328) + ") " + solution(328));
		System.out.println("BinaryGap of 1162 is (binary representations " + Integer.toBinaryString(1162) + ") " + solution(1162));
		System.out.println("BinaryGap of 66561 is (binary representations " + Integer.toBinaryString(66561) + ") " + solution(66561));
		System.out.println("BinaryGap of 74901729 is (binary representations " + Integer.toBinaryString(74901729) + ") " + solution(74901729));
		System.out.println("BinaryGap of 1376796946 is (binary representations " + Integer.toBinaryString(1376796946) + ") " + solution(1376796946));
	}

}
