package tomkous.algos.ms;

public class Rfq {
	
    private final String clientId;
    private final String isin;
    private final long requestedQuantity;
    private final double yieldSpread; // Spread over benchmark in basis points

    public Rfq(String clientId, String isin, long requestedQuantity, double yieldSpread) {
        this.clientId = clientId;
        this.isin = isin;
        this.requestedQuantity = requestedQuantity;
        this.yieldSpread = yieldSpread;
    }

    public String getClientId() { return clientId; }
    public String getIsin() { return isin; }
    public long getRequestedQuantity() { return requestedQuantity; }
    public double getYieldSpread() { return yieldSpread; }
}

