package tomkous.algos;

import java.util.HashSet;
import java.util.Set;

public class BetterProgrammerTask3 {

    public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a set of elements that can be found only in set a or set b,
          but not in both Sets.
          The method should not change the content of the parameters.
         */
    	
    	Set<Object> res = new HashSet<>();
    	
    	for (Object obj1 : a){
    		
    		if(!b.contains(obj1))
    			res.add(obj1);
    	}
    		
    	for (Object obj2 : b){
    		
    		if(!a.contains(obj2))
    			res.add(obj2);
    	}
    	
    	return res;
    }
}