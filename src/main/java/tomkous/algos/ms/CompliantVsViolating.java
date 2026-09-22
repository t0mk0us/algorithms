package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompliantVsViolating {
	
	private static List<BondPosition> bps;
	public static List<BondPosition> bsComp = new ArrayList<BondPosition>();
	public static List<BondPosition> bsViol = new ArrayList<BondPosition>();

	public CompliantVsViolating(List<BondPosition> bsComp, List<BondPosition> bsViol) {
		super();
		this.bsComp = bsComp;
		this.bsViol = bsViol;
	}

	public static class BondPosition {
	    private final String bookName;
	    private final String ticker;
	    private final long dv01; // Dollar Value of a Basis Point (Risk Metric)

	    public BondPosition(String bookName, String ticker, long dv01) {
	        this.bookName = bookName;
	        this.ticker = ticker;
	        this.dv01 = dv01;
	    }

	    public String getBookName() { return bookName; }
	    public String getTicker() { return ticker; }
	    public long getDv01() { return dv01; }
	    
	    @Override
	    public String toString() {
	    	
	    	return "Book Name: " + bookName + ", Ticker: " + ticker + ", dv01:" + dv01 + "\n";
	    }
	}
	
	public static Map<Boolean, List<BondPosition>> findViolating(List<BondPosition> lbps, long riskThld) {
		
		Map<Boolean, List<BondPosition>> res = new HashMap<Boolean, List<BondPosition>>();
		
		
		for(BondPosition b : lbps) {
			
			if(b.getDv01() > 50000) {
				bsViol.add(b);
			} else
				bsComp.add(b);
		}
		
		res.put(true, bsViol);
		res.put(false, bsComp);
		
		return res;
	}
	
	public Map<Boolean, List<BondPosition>> findViolatingStreams(List<BondPosition> lbps, long riskThld) {
		
		 bsViol = lbps.stream()
				.filter(bp -> (bp.getDv01() > riskThld))
				.toList();
		 
		 bsComp = lbps.stream()
					.filter(bp -> (bp.getDv01() <= riskThld))
					.toList();
		 
		 Map<Boolean, List<BondPosition>> res = new HashMap<Boolean, List<BondPosition>>();
		 
		 res.put(true, bsViol);
		 res.put(false, bsComp);
		 
		 return res;
	}
	
	public Map<Boolean, List<BondPosition>> findViolatingStreamsOptimal(List<BondPosition> lbps, long riskThld) {
	    return lbps.stream()
	        .collect(Collectors.partitioningBy(bp -> bp.getDv01() > riskThld));
	}
	
	public static void main(String[] args) {
		
		bps = new ArrayList<BondPosition>();
		
		bps.add(new BondPosition("Book1", "ABC", 10000));
		bps.add(new BondPosition("Book1", "BCD", 20000));
		bps.add(new BondPosition("Book1", "CDE", 30000));
		bps.add(new BondPosition("Book1", "DEF", 35000));
		bps.add(new BondPosition("Book1", "FGI", 24000));
		bps.add(new BondPosition("Book1", "GIJ", 50000));
		bps.add(new BondPosition("Book1", "IJK", 60000));
		bps.add(new BondPosition("Book1", "KLM", 70000));
		bps.add(new BondPosition("Book1", "LMN", 80000));
		bps.add(new BondPosition("Book1", "MNO", 90000));
		bps.add(new BondPosition("Book1", "NOP", 100000));
		bps.add(new BondPosition("Book1", "OPR", 110000));
		
		Map<Boolean, List<BondPosition>> resBps = findViolating(bps, 50000);
		
		System.out.println("Violating vs Compliant: " + resBps);
		
	}
}
