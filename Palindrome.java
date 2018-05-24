package tomkous.algos;

import java.util.Scanner;

import junit.framework.TestCase;

public class Palindrome {
    public static boolean isPalindrome(String word) throws UnsupportedOperationException {
   
        for (int i = 1; i<=(word.length()+1)/2; i++){
        	System.out.println("i is " + i);
        	System.out.println(String.valueOf(word.charAt(i-1)));
        	System.out.println(String.valueOf(word.charAt(word.length()-i)));
        	if (String.valueOf(word.charAt(i-1)).equalsIgnoreCase(String.valueOf(word.charAt(word.length()-i))))
        			continue;
        	else 
        		return false;
        }
        
        	return true;
  
    }
    
    public static boolean isPalindrome1(String word) throws UnsupportedOperationException {
    	 System.out.println(word.substring(0,word.length()));
    	 System.out.println("comparing " + word.substring(0,1) + " " + word.substring(word.length()-1,word.length()));
    	 
    	 if (word.length()==1){
    		 System.out.println("word length is " + word.length());
    		 System.out.println("returning true ");
     		return true;
     	} else if(word.substring(0,1).equalsIgnoreCase(word.substring(word.length()-1,word.length()))){
        	
        	if (word.length()==2){
        		return true;
        	}
        	else {
        		System.out.println("word length is " + word.length());
        	return	isPalindrome1(word.substring(1, word.length()-1));    
        	}
        } 
        	return false;

    }

    public static void isPalindrome2()
    {
       String original, reverse = ""; // Objects of String class
       Scanner in = new Scanner(System.in);
  
       System.out.println("Enter a string to check if it is a palindrome");
       original = in.nextLine();
  
       int length = original.length();
  
       for ( int i = length - 1; i >= 0; i-- )
          reverse = reverse + original.charAt(i);
       
       if (original.equalsIgnoreCase(reverse))
          System.out.println("Entered string is a palindrome.");
       else
          System.out.println("Entered string isn't a palindrome.");
  
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Racecar"));
        System.out.println(Palindrome.isPalindrome1("Avocado"));
        System.out.println(Palindrome.isPalindrome1("Eve"));
        Palindrome.isPalindrome2();
    }
}


