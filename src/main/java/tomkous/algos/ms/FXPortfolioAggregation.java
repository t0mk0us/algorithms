package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FXPortfolioAggregation {
	
	private List<Trade> trades;
	
	public FXPortfolioAggregation(List<Trade> trades) {
		super();
		this.trades = trades;
	}

	public void addTrade(Trade t) {
		
		if(trades == null) {
			trades = new ArrayList<Trade>();
			trades.add(t);
		} else {
			trades.add(t);
		}
	}

	public static class Trade {
		
		private String isin;
		private long bookId;
		private int notionalAmount;
		private String currency;
		
		public Trade(String isin, long bookId, int notionalAmount, String currency) {
			super();
			this.isin = isin;
			this.bookId = bookId;
			this.notionalAmount = notionalAmount;
			this.currency = currency;
		}
		public String getIsin() {
			return isin;
		}
		public void setIsin(String isin) {
			this.isin = isin;
		}
		public long getBookId() {
			return bookId;
		}
		public void setBookId(long bookId) {
			this.bookId = bookId;
		}
		public int getNotionalAmount() {
			return notionalAmount;
		}
		public void setNotionalAmount(int notionalAmount) {
			this.notionalAmount = notionalAmount;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
	}

	public Map<Long, Long> totalExposure() {
		
		Map<Long, Long> totalExpByBookId = trades.stream()
				.filter(t -> (t.getCurrency().equals("USD")))
				.filter(t -> (t.getNotionalAmount() > 1000))
				.collect(Collectors.groupingBy(
						Trade::getBookId,
						Collectors.summingLong(Trade::getNotionalAmount)
								));
		
		return totalExpByBookId;
	}
	
	public static void main(String[] args) {
		
		List<Trade> myTrades = new ArrayList<Trade>();
		FXPortfolioAggregation myAggregation = new FXPortfolioAggregation(myTrades);
		
		myAggregation.addTrade(new Trade("ABC", 1200, 1005, "USD"));
		myAggregation.addTrade(new Trade("BCD", 900, 900, "USD"));
		myAggregation.addTrade(new Trade("CDE", 1202, 1025, "CAD"));
		myAggregation.addTrade(new Trade("DEF", 1200, 1005, "USD"));
		myAggregation.addTrade(new Trade("EFI", 1205, 1005, "EUR"));
		myAggregation.addTrade(new Trade("FIJ", 1200, 1005, "USD"));
		myAggregation.addTrade(new Trade("ABC", 900, 1005, "USD"));
		myAggregation.addTrade(new Trade("FIJ", 900, 805, "USD"));
		myAggregation.addTrade(new Trade("CDE", 1202, 1105, "CAD"));
		myAggregation.addTrade(new Trade("BCD", 900, 1305, "USD"));
		
		System.out.println("Total Exposure is " + myAggregation.totalExposure());

	}
}
