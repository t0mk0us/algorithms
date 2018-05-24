package tomkous.algos;

import java.util.*;


public class BetterProgramerTask {

    public static int[] retainPositiveNumbers(int[] a) {
        /*
          Please implement this method to
          return a new array with only positive numbers from the given array.
          The elements in the resulting array shall be sorted in the ascending order.
         */
    	
    	int[] res = new int[a.length];
    	
    	SortedSet<Integer> set = new TreeSet<>();
    	
    	int j = 0;
    	
    	for(int i : a){
    		if(i%2 == 0)
    			//res[j] = i;
    		set.add(i);
    	}
    	j = 0;
    	for(int k : set){
    			res[j] = k;
    			j++;
    	}
    	
    	return res;
    }
    
    public static void main(String args[]){
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("please enter numbers");
    	
    	int[] input = {1,2,3,4,5,6,7};
    	
    	System.out.println(retainPositiveNumbers(input));
    }
}
