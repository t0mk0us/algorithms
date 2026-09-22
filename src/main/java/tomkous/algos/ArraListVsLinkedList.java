package tomkous.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArraListVsLinkedList {
	
	private static List<Integer> aList = new ArrayList<Integer>();
	private static List<Integer> lList = new LinkedList<Integer>();
	
    public static void main(String[] args) {
    	
    	aList.add(1);
    	aList.add(2);
    	aList.add(3);
    	aList.add(4);
    	aList.add(5);
    	aList.add(6);
    	aList.add(7);
    	
    	System.out.println("aList is " + aList);
    	
    	lList.add(2);
    	lList.add(3);
    	lList.add(1);
    	lList.add(4);
    	lList.add(5);
    	lList.add(6);
    	lList.add(7);
    	
    	System.out.println("lList is " + lList);
    	
    	aList.remove(3);
    	lList.remove(3);
    	
    	System.out.println("aList is " + aList);
    	System.out.println("lList is " + lList);
    }

}
