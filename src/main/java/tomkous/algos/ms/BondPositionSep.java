package tomkous.algos.ms;

public class BondPositionSep {
    private final String bookName;
    private final String ticker;
    private final long dv01; // Dollar Value of a Basis Point (Risk Metric)

    public BondPositionSep(String bookName, String ticker, long dv01) {
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

