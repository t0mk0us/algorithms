package tomkous.algos;

public class SmallestInterval {
	
	 public static void main(String a[]) {
		 
		 SmallestInterval si = new SmallestInterval();
		 
		 int[] numbers1 = {0,1,4,5,6,7};
		 int[] numbers2 = {2,4,5,6,7};
		 int[] numbers3 = {4,6,7};
		 int[] numbers4 = {4,5,7,4};
		 int[] numbers5 = {1,0,5,3};
		 
		 System.out.print("Smallest interval between two numbers of ");
		 si.printArrayElements(numbers1);
		 System.out.println(" is " + si.findSmallestInterval(numbers1));
		 System.out.print("Smallest interval between two numbers of ");
		 si.printArrayElements(numbers2);
		 System.out.println(" is " + si.findSmallestInterval(numbers2));
		 System.out.print("Smallest interval between two numbers of ");
		 si.printArrayElements(numbers3);
		 System.out.println(" is " + si.findSmallestInterval(numbers3));
		 System.out.print("Smallest interval between two numbers of ");
		 si.printArrayElements(numbers4);
		 System.out.println(" is " + si.findSmallestInterval(numbers4));
		 System.out.print("Smallest interval between two numbers of ");
		 si.printArrayElements(numbers5);
		 System.out.println(" is " + si.findSmallestInterval(numbers5));
	 }

	 public void printArrayElements(int[] a) {
	 
		 	for (int i = 0; i < a.length - 1; i++) {
		 		
		 		System.out.print( a[i] + ",");
		 	}
		 	
	 		System.out.print( a.length );
	 }
	 
    public int findSmallestInterval(int[] a) {
        /*
          Please implement this method to
          return the number that is the smallest interval 
          between any two of array integer elements.
         */
    	
    	int result = Math.abs(a[0] - a[1]);
    	
    	int temp = 0;
    	
    	for(int i = 0; i < a.length-1; i++){
    		
    		for(int j = i + 1; j < a.length; j++) {
    		
	    		temp = Math.abs(a[i] - a[j]);
	    		
	    		if (temp < result)
	    			result = temp;
    		}
    	}
    	
		/*
		 * for(int j = 0; j < a.length; j++) {
		 * 
		 * if (Math.abs(a[j]) < result) result = Math.abs(a[j]); }
		 */
    	
    	return result;
    }
}