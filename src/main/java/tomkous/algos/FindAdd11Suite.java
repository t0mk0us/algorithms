package tomkous.algos;

public class FindAdd11Suite {

	public static void main(String arg[]) {

    	System.out.println(findTheNext(14, 11, 1, 5));	
	}
	
	/* a     b    c    d
	 * 14 + (11 * 1) = 25
	 * 25 + (11 * 2) = 47
	 * 47 + (22 * 2) = 91
	 * 91 + (44 * 2) = 179
	 */
	
	public static int findTheNext(int a, int b, int c, int stop) {
		
		int d = 0;
				
		  do {
			  d = a + b; 
			  System.out.println("Number " + c + " is " + a +" + " + b + " = " +  + d);
			  b = b * 2; 
			  c++; 
			  a = d; 
		  } while (c < stop);
		
		  System.out.println("The result is " + a);
		  
		return d;
		}
	}
