package tomkous.algos;

import java.util.LinkedList;
import java.util.List;

public class Gift {
	
	private static List<SomePerson> people = new LinkedList<SomePerson>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		for(i=0; i<30; i++) {
			people.add(i, new SomePerson(i));
		}
		
		i=0;
		
		while(i<people.size()-1) {
			
			people.get(i).giveAGift(i, (i+1));
			System.out.println("Person " + people.get(i+1).getID() + " just got a gift" + " from " + people.get(i).getID());
			 i++;
		}
		
		
		
		people.get(0).giveAGift(i-1, 0);
		System.out.println("Person " + people.get(0).getID() + " just got a gift" + " from " + people.get(i).getID());


	}

}
