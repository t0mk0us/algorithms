package tomkous.algos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
     
    public static void main(String a[]){
    	StringHaveDups shd = new StringHaveDups();
    	char b = 0;
    	StringBuffer sb = new StringBuffer();
    	try{
    		b = (char) System.in.read();
    		sb = sb.append(""+b);
    		//System.in.read(b, 10, 10);
    		shd.findDuplicateChars("Hello Darling Tomkous");
    		if (shd.haveDups("Hello Darling Tomkous"))
    			System.out.println("Oooooh Yessss");
    		System.out.print(sb);
    	}catch(IOException ioe){
    		System.out.println("Are you sure you were typing???");
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
