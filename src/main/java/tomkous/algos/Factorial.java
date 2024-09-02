package tomkous.algos;

import java.util.Scanner;

public class Factorial {

	public static int findFactorial(int number){
		
		int resNumber=number;
		
		for(int i = number-1; i > 1; i--){
			
			resNumber = resNumber * i;
			System.out.println(resNumber);
		}		
		return resNumber;		
		
	}
	
	public static int findFactorialRecursive(int number){
		
		int resNumber=number;
		
		number -= 1;
		
		if (number > 1)
			
			System.out.println(resNumber);
			resNumber = resNumber * findFactorialRecursive(number);
				
		return resNumber;		
		
	}
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        
        System.out.println("please enter a number");
        
        int nmbr = Integer.valueOf(sc.nextLine());
        
        System.out.println("iteration " + findFactorial(nmbr));
        System.out.println("recursion " + findFactorialRecursive(nmbr));

        
	}

}
