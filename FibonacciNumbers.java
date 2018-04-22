package com.bank.model;

import java.util.Scanner;

public class FibonacciNumbers {
	
	public void printFibonacciNmbrs(int n){
		
		int fib1 = 1;
		int fib2 = 1;
		int fib = 0;
		
		System.out.println(fib1);
		System.out.println(fib2);
		
		for(int i = 3; i <= n; i++){
			fib = fib1 + fib2;
			
			System.out.println(fib);
			fib1 = fib2;
			fib2 = fib;
		}
	}
	
	  public static long fibonacci(long number) {
		    if ((number == 0) || (number == 1)) // base cases
		      return number;
		    else
		      // recursion step
		      return fibonacci(number - 1) + fibonacci(number - 2);
		  }
	
	public static void main(String[] args) {
		
		FibonacciNumbers fb = new FibonacciNumbers();
		
		Scanner s = new Scanner(System.in);
		int number;
		
		System.out.println("Please enter a number");
		
		number = Integer.valueOf(s.nextLine());
		
		   for (int counter = 0; counter <= number; counter++)
			      System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
			  
	}

}
