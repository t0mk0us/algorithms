package tomkous.algos;

import java.util.Scanner;

public class Factorial {

	public static int findFactorial(int number){
		
		int resNumber=number;
		
		for(int i = number-1; i > 1; i--){
			
			resNumber = resNumber * i;
		
		}		
		return resNumber;		
		
	}
	
	public static int findFactorialRecursive(int number){
		
		int resNumber=number;
		
		number -= 1;
		
		if (number > 1)
			
			resNumber = resNumber * findFactorialRecursive(number);
				
		return resNumber;		
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        System.out.println("please enter a number");
        
        int nmbr = Integer.valueOf(sc.nextLine());
        
        System.out.println("iteration " + findFactorial(nmbr));
        System.out.println("recursion " + findFactorialRecursive(nmbr));

        
	}

}
