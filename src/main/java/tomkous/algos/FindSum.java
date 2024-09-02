package tomkous.algos;

import java.util.List;
import java.util.LinkedList;

public class FindSum {
	
    public static void main(String a[]){
    	
        LinkedList<Integer> intList = new LinkedList<Integer>();  
        
        intList.add(0);
        intList.add(2);
        intList.add(5);
        intList.add(3);
        intList.add(9);
        intList.add(7);
        intList.add(6);
        intList.add(4);
        intList.add(3);
        intList.add(0);
        intList.add(7);
        intList.add(2);
        
        System.out.println("The array intList[] is:");
        
        for(int i = 0; i < intList.size(); i++) {
        	
        	System.out.println("[" + intList.get(i) + "]");
        }
        
        System.out.println("");
        
        FindSum fs = new FindSum();  
        
        try {
        	System.out.println("Sum of numbers between elements 2 and 12 is ");
			System.out.println(fs.findSumOfNumbersBetween(intList, 2, 12));
		
			System.out.println("Sum of numbers between elements 0 and 1 is ");
	        System.out.println(fs.findSumOfNumbersBetween(intList, 0, 1));
	        
	        System.out.println("Sum of numbers between elements 3 and 9 is ");
	        System.out.println(fs.findSumOfNumbersBetween(intList, 3, 9));
	        
	        System.out.println("Sum of numbers between elements 4 and 11 is ");
	        System.out.println(fs.findSumOfNumbersBetween(intList, 4, 11));
	        
	        System.out.println("Sum of numbers between elements 1 and 10 is ");
	        System.out.println(fs.findSumOfNumbersBetween(intList, 1, 10));
	        
	        System.out.println("Sum of numbers between elements 5 and 9 is ");
	        System.out.println(fs.findSumOfNumbersBetween(intList, 5, 9));
	        
	        System.out.println("Sum of numbers between elements 4 and 40 is ");
	        System.out.println(fs.findSumOfNumbersBetween(intList, 4, 40));
		        
		} catch (Exception e) {
			System.out.println("OOPS, n1 or n2 (or both) is out of range");
		} 
        
    }

    public int findSumOfNumbersBetween(List<Integer> numbers, int n1, int n2 ) throws Exception {
        /*
          Please implement this method to
          return the sum of the numbers' elements located between indexes n1 and n2
         */
    	
    	int result = 0;
    	
    	if (n1 > numbers.size() || n2 > numbers.size()) {
    		
    		throw new Exception();
    	}
    	
    	for (int i = 1; i < n2 - 2; i++) {
    		
    		if (i == n1) {
    			
    			do {
    				result += numbers.get(i + 1);
    				i++;

    			} while (i < n2 - 1);
    		}
    	}
    	
    	return result;
    } 
}
