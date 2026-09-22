package tomkous.algos.codility;

public class FrogJmp {
	
	public static int solution(int X, int Y, int D) {
		
		int minJumps = 0;
		
		int distance = Y - X;
		
		if (distance % D == 0)
			minJumps = distance/D;
		else
			minJumps = distance/D + 1;
		
		return minJumps;
	}
	
	public static void main(String[] args) {
		
		int X = 10;
		int Y = 85;
		int D = 30;
		
		int X1 = 10;
		int Y1 = 1_000_000_000;
		int D1 = 30;
		
		int D2 = 10;
		int D4 = 7;
		
		System.out.println("It takes " + solution(X, Y, D) + " jumps of " + D + " to go from " + X + " to " + Y);
		System.out.println("It takes " + solution(X, Y, D4) + " jumps of " + D4 + " to go from " + X + " to " + Y);
		System.out.println("It takes " + solution(X1, Y1, D1) + " jumps of " + D1 + " to go from " + X1 + " to " + Y1);
		System.out.println("It takes " + solution(X1, Y1, D2) + " jumps of " + D2 + " to go from " + X1 + " to " + Y1);
	}

}
