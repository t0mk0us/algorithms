package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class YielCurveExtraction {
	
	private List<YieldCurve> curves;
	
	public YielCurveExtraction(List<YieldCurve> curves) {
		super();
		this.curves = curves;
	}

	public static class TenorPoint {
	    private final String maturity; // e.g., "10Y"
	    private final double yield;    // e.g., 4.25

	    public TenorPoint(String maturity, double yield) {
	        this.maturity = maturity;
	        this.yield = yield;
	    }
	    public String getMaturity() { return maturity; }
	    public double getYield() { return yield; }
	    
		@Override
		public String toString() {
			return "TenorPoint [maturity = " + maturity + ", yield = " + yield + "]";
		}    
	}

	public static class YieldCurve {
	    private final String region; // e.g., "US", "UK"
	    private final List<TenorPoint> points;

	    public YieldCurve(String region, List<TenorPoint> points) {
	        this.region = region;
	        this.points = points;
	    }
	    public String getRegion() { return region; }
	    public List<TenorPoint> getPoints() { return points; }
	}

	//public static List<TenorPoint> extractTenorpoints(List<YieldCurve> c) {
		public static void extractTenorpoints(List<YieldCurve> c) {
		
	List<TenorPoint> listOfPoints = new ArrayList<TenorPoint>(); 
				
		for(YieldCurve curve : c) {
			listOfPoints.addAll(curve.getPoints().stream()
			.filter(p -> (p.getYield() > 0))
			.distinct()
			//.sorted()
			.toList());					
		}
		System.out.println("Extracted " + listOfPoints.size() + " distinct TenorPoints");
		listOfPoints.forEach(System.out::println);
		//return listOfPoints;
	}
		
	//public static List<TenorPoint> extractTenorpointsOptimal(List<YieldCurve> c) {
		public static void extractTenorpointsOptimal(List<YieldCurve> c) {
				
	    List<TenorPoint> listOfPoints = c.stream()
	        .flatMap(curve -> curve.getPoints().stream()) // Flattens List<YieldCurve> into Stream<TenorPoint>
	        .filter(p -> p.getYield() > 0)
	        .distinct()                                   // Distinct is evaluated across the combined global list
	        .collect(Collectors.toList());
	    
	    System.out.println("Extracted optimally " + listOfPoints.size() + " distinct TenorPoints");
	    listOfPoints.forEach(System.out::println);
	    
	    //return;
	}
	
	public static void main(String[] args) {
		
		List<YieldCurve> curves = new ArrayList<YieldCurve>();
		List<TenorPoint> points = new ArrayList<TenorPoint>();
		List<String> regions = List.of("US", "UK", "CA", "SW", "JP", "DE");
		List<Double> maturities = List.of(3.25, 5.5, 6.5, 4.75, 7.5, 10.0);
		
		for(int i = 0; i < 10; i++) {
			
			for(int j = 0; j < 10; j++)
				//points.add(new TenorPoint(Math.random() * 10 + "Y", new Random().nextDouble()));
				points.add(new TenorPoint(maturities.get(new Random().nextInt(maturities.size())) + "Y", Math.round(((Math.random() * 4) - 2) * 100.0) / 100.0));
			
			curves.add(new YieldCurve(regions.get(new Random().nextInt(regions.size())), points));
		}
		
		//System.out.println(extractTenorpoints(curves) + "\n\n");
		extractTenorpoints(curves);
		
		extractTenorpointsOptimal(curves);
		
		System.out.println("Positive Yield:");
		
		for(TenorPoint p : points) {
			
			if (p.getYield() > 0) {
				System.out.println(p + "\n");
			}
		}
		
		System.out.println("Negative Yield:");
		
		for(TenorPoint p : points) {
			
			if (p.getYield() < 0) {
				System.out.println(p + "\n");
			}
		}
	}
}
