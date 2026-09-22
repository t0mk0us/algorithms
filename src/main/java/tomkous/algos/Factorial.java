package tomkous.algos;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

	public static BigInteger findFactorial(long number){
		
		BigInteger resNumber= BigInteger.valueOf(number);
		
		for(long i = Long.valueOf(number); Long.valueOf(i) > Long.valueOf(1); Long.valueOf(i - 1)){
			
			resNumber = resNumber.multiply(resNumber);
			System.out.println(resNumber);
		}		
		return resNumber;		
		
	}
	
	public static BigInteger findFactorialRecursive(long number){
		
		System.out.println(number);
		
		if (number == 0 || number == 1) {	
			return BigInteger.ONE;
		}
				
		return BigInteger.valueOf(number).multiply(findFactorialRecursive(number - 1));		
		
	}
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        
        System.out.println("please enter a number");
        
        int nmbr = Integer.valueOf(sc.nextLine());
        System.out.println("Entered number is " + nmbr);
        
        //System.out.println("iteration " + findFactorial(nmbr));
        System.out.println("recursion " + findFactorialRecursive(nmbr));       
	}
}
