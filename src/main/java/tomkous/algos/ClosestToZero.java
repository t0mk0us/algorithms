package tomkous.algos;

public class ClosestToZero {
	
	 public static void main(String a[]) {
		 
		 ClosestToZero gcz = new ClosestToZero();
		 
		 int[] numbers1 = {-4,-1,-2,-3,1,4,5,6,7};
		 int[] numbers2 = {-4,-1,-2,4,5,6,7};
		 int[] numbers3 = {-4,-1,-2,-1,4,6,7};
		 int[] numbers4 = {-4,-1,-2,-3,4,5,7};
		 int[] numbers5 = {-4,-1,-2,-3,1,0};
		 
		 System.out.print("Closest to zero number of ");
		 gcz.printArrayElements(numbers1);
		 System.out.println(" is " + gcz.getClosestToZero(numbers1));
		 System.out.print("Closest to zero number of ");
		 gcz.printArrayElements(numbers2);
		 System.out.println(" is " + gcz.getClosestToZero(numbers2));
		 System.out.print("Closest to zero number of ");
		 gcz.printArrayElements(numbers3);
		 System.out.println(" is " + gcz.getClosestToZero(numbers3));
		 System.out.print("Closest to zero number of ");
		 gcz.printArrayElements(numbers4);
		 System.out.println(" is " + gcz.getClosestToZero(numbers4));
		 System.out.print("Closest to zero number of ");
		 gcz.printArrayElements(numbers5);
		 System.out.println(" is " + gcz.getClosestToZero(numbers5));
	 }

	 public void printArrayElements(int[] a) {
	 
		 	for (int i = 0; i < a.length - 1; i++) {
		 		
		 		System.out.print( a[i] + ",");
		 	}
		 	
	 		System.out.print( a.length );
	 }
	 
    public int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */
    	
    	int result = 0;
    	
    	for(int i = 0; i < a.length; i++){
    		
    		if (Math.abs(a[i]) > 0)
    			result = Math.abs(a[i]);
    		
    		break;
    	}
    	
    	for(int j = 0; j < a.length; j++) {
    		
    		if (Math.abs(a[j]) < result)
    			result = Math.abs(a[j]);
    	}
    	
    	return result;
    }
}