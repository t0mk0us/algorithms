package tomkous.algos;

public class LuthCheck {
	
    public static void main(String a[]){
    	
    	LuthCheck luthCheck = new LuthCheck();
    	
    	String card1 = "1234567890123456";
    	String card2 = "79927398713";
    	String card3 = "277395422";
    	
    	System.out.println("Card1 " + card1 + " is " + luthCheck.doLuthCheck(card1));
    	System.out.println("7 + 9 + 9 + 4 + 7 + 6 + 9 + 7 + 7 + 2 + 3 = 70");
    	System.out.println("Card2 " + card2 + " is " + luthCheck.doLuthCheck(card2));
    	System.out.println("Card3 " + card3 + " is " + luthCheck.doLuthCheck(card3));
    }
	
public boolean doLuthCheck(String cardNmbr) {
		
		boolean result = false;
		
		int count = 1;
		int sum = 0;
		int value = 0;
		
		for (int i=cardNmbr.length() - 1; i >= 0; i--) {
			
			int next = (cardNmbr.charAt(i) - '0');
			int temp = 0;
			
			System.out.println("Char at " + i + " is " + cardNmbr.charAt(i));
			System.out.println("Digit at " + i + " is " + next);						
			
			if (count%2 == 0) {
				temp = next * 2;			
				System.out.println("Temp * 2 is " + temp);
				
				if (temp >= 10) {
					value = temp/10 + temp % 10;

				} else {
					
					value = temp;
				}
				
				System.out.println("value is " + value);
				
			} else {
				value = next;
				System.out.println("value is " + value);
			}
			sum += value;
			
			System.out.println("new sum is " + sum);
			count++;
			value = 0;
		}
		
		if (sum%10==0)
			 return true;
		else
			return false;
	}

}
