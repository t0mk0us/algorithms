package tomkous.algos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
public class StringHaveDups {
 
    public void findDuplicateChars(String str){
         
        Map<Character, Integer> dupMap = new HashMap<Character, Integer>(); 
        char[] chrs = str.toCharArray();
        for(Character ch:chrs){
            if(dupMap.containsKey(ch)){
                dupMap.put(ch, dupMap.get(ch)+1);
            } else {
                dupMap.put(ch, 1);
            }
        }
        Set<Character> keys = dupMap.keySet();
        for(Character ch:keys){
            if(dupMap.get(ch) > 1){
                System.out.println(ch+"--->"+dupMap.get(ch));
            }
        }
    }
     
    public static void main(String a[]) throws IOException{
    	StringHaveDups shd = new StringHaveDups();
    	char b = '0';
    	StringBuffer sb = new StringBuffer();
    	
    	Scanner scan = new Scanner(System.in);
 
    	System.out.println("please, enter a phrase");
    	
    	String s = scan.nextLine();
    	
    	try{
    		
    		if (s.equals("")) {
    			System.out.println("You have entered an empty string. Are you sure you where typing ??");
    			System.exit(7);
    		}
    		shd.findDuplicateChars(s);
    		if (shd.haveDups(s)) 
    			System.out.println(s + " have duplicate characters");
    		else
    			System.out.println(s + " does not have duplicate characters");
    		
			/*
			 * shd.findDuplicateChars("Hello Darling Tomkous"); if
			 * (shd.haveDups("Hello Darling Tomkous")) System.out.println("Oooooh Yessss");
			 * System.out.println(sb); System.out.println("Entered phrase is:");
			 * System.out.println(s);
			 */
    		
    	}finally{
    		System.out.println("This person is stupid");
    	}
    }
    
    public boolean haveDups(String str){
        
        Map<Character, Integer> dupMap = new HashMap<Character, Integer>(); 
        char[] chrs = str.toCharArray();
        for(Character ch:chrs){
            if(dupMap.containsKey(ch)){
                dupMap.put(ch, dupMap.get(ch)+1);
                return true;
            } else {
                dupMap.put(ch, 1);
            }
        }
		return false;

    }
}
