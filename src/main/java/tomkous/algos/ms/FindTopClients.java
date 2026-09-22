package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tomkous.algos.ms.FXPortfolioAggregation.Trade;

public class FindTopClients {
	
	private static List<Rfq> rfqs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rfqs = new ArrayList<Rfq>();
		
		rfqs.add(new Rfq("Tamara", "ABC", 500, 3.55));
		rfqs.add(new Rfq("Tamara", "BCD", 700, 5.55));
		rfqs.add(new Rfq("Tamara", "CDE", 1500, 7.55));
		rfqs.add(new Rfq("Kolia", "ABC", 20, 3.55));
		rfqs.add(new Rfq("Kolia", "BCD", 50, 5.55));
		rfqs.add(new Rfq("Kolia", "CDE", 30, 7.55));
		rfqs.add(new Rfq("Veronica", "ABC", 700, 3.55));
		rfqs.add(new Rfq("Veronica", "BCD", 900, 5.55));
		rfqs.add(new Rfq("Hannane", "ABC", 50, 3.55));
		rfqs.add(new Rfq("Hannane", "CDE", 100, 7.55));
		
		List<Map.Entry<String, Long>> topThree;			
			
			List<Map.Entry<String, Long>> clients = rfqs.stream()
					.collect(Collectors.groupingBy(
							Rfq::getClientId,
							Collectors.summingLong(Rfq::getRequestedQuantity)
			))
				.entrySet().stream()
				
				.sorted(Map.Entry.<String,Long>comparingByValue().reversed())
				.limit(3)
				.collect(Collectors.toList());
			

			System.out.println(clients.toString());
	}		

}
