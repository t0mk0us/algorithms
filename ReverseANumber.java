package tomkous.algos;

import java.util.Scanner;

public class ReverseANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a number to reverse");
		
		Integer nmbr = Integer.valueOf(sc.nextLine());
		
		
		System.out.println("Reversed number is " + reverse(nmbr));	

	}

	private static int reverse(Integer nmbr) {
		// TODO Auto-generated method stub
		
		int nmbrDigits = Integer.toString(nmbr).length();
		String res = "";
		
		for(int i = nmbrDigits; i>0; i--){
		    res = res + nmbr%10;
		    nmbr = nmbr/10;
		    
		    //System.out.println(res);
		}
		
		return Integer.valueOf(res);
	}

}
