package tomkous.algos;

public class MegaStore {

    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }
    
    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	
    	double finalPrice = 0.0;
    		
    		if (discountType.equals(DiscountType.Standard)) {
    			
    			finalPrice = totalPrice - (totalPrice * 0.06);
    		} else if (discountType.equals(DiscountType.Seasonal)) {
    			
    			finalPrice = totalPrice - (totalPrice * 0.12);
    			
    		} else if (discountType.equals(DiscountType.Weight)) {
    		
	    		if (cartWeight > 10) {
	    			
	    			finalPrice = totalPrice - (totalPrice * 0.18);
	    		} else {
	    			
	    			finalPrice = totalPrice - (totalPrice * 0.06);
	    		}
    	}
    		return finalPrice;
    }
    
    public static void main(String[] args) {        
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}
