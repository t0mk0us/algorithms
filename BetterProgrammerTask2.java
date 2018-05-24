package tomkous.algos;


public class BetterProgrammerTask2 {

    public static int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */
    	
    	int res = 9;
    	
    	for(int i = 0; i < a.length; i++){
    		
    		if (Math.abs(a[i]) < res)
    			res = Math.abs(a[i]);
    		
    	}
    	
    	return res;
    }
}