package tomkous.algos;

import java.util.List;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	
    	System.out.println("Starting from " + fromRow + ", " + fromColumn);
    	System.out.println("Going to " + toRow + ", " + toColumn);
    	
    	if ((fromRow > (gameMatrix.length - 1) || fromColumn > (gameMatrix.length - 1)) || (fromRow < 0 || fromColumn < 0) || (toRow > (gameMatrix.length - 1) || toColumn > (gameMatrix.length - 1)) || (toRow < 0 || toColumn < 0)) {
    		
    		System.out.println("Can't move out of Matrix");
    		return false;
    	}
    	
    	//travel vertical
    	if (toRow > fromRow) {
	    	for (int i=fromRow; i<toRow; i++) {
	    		
	    		if (gameMatrix[i][fromColumn]) {		
	    			System.out.println("Moved to " + i + ", " + fromColumn);
	    			continue;
	    		}
	    		else {
	    			System.out.println("Can't move to " + i + ", " + fromColumn);
	    			return false;
	    		}
	    	}
    	} else {
    		
    		for (int i=fromRow; i>toRow; i--) {
	    		
	    		if (gameMatrix[i][fromColumn]) {		
	    			System.out.println("Moved to " + i + ", " + fromColumn);
	    			continue;
	    		}
	    		else {
	    			
	    			System.out.println("Can't move to " + i + ", " + fromColumn);
	    			return false;
	    		}
	    	}
    	}
    	
    	//travel horisontal
    	if (toColumn > fromColumn) {
	    	for (int j=fromColumn; j<toColumn; j++) {
	    		
	    		if (gameMatrix[toRow][j]) {
	    			
	    			System.out.println("Moved to " + toRow + ", " + j);
	    			continue;
	    		}
	    		else {
	    			System.out.println("Can't move to " + toRow + ", " + j);
	    			return false;   
	    		}
	    	}
    	} else {
    		for (int j=fromColumn; j>toColumn; j--) {
    			
	    		if (gameMatrix[toRow][j]) {
	    			
	    			System.out.println("Moved to " + toRow + ", " + j);
	    			continue;
	    		}
	    		else {
	    			
	    			System.out.println("Can't move to " + toRow + ", " + j);
	    			return false;   	
	    		}
	    	}
    	}
    	System.out.println("Arrived to " + toRow + ", " + fromColumn);
    	return true;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
            {false, true,  true,  false, false, false},
            {true,  true,  true,  false, false, false},
            {true,  true,  true,  true,  true,  true},
            {false, true,  true,  false, true,  true},
            {false, true,  true,  true,  false, true},
            {false, false, false, false, false, false},
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}
