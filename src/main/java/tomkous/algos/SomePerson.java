package tomkous.algos;

public class SomePerson {
	
	private boolean hasAGift;
	private int ID;
	private SomePerson giver;
	
	
	public SomePerson(int nmbr) {
		this.ID = nmbr;
		this.hasAGift = false;
	}


	public void giveAGift(int idGiver, int idReceiver) {
		if(this.ID == idReceiver) {
			this.hasAGift = true;
			this.giver = new SomePerson(idGiver);
		}
	}
	
	public void setID(int nmbr){
		this.ID = nmbr;
	}
	
	public int getID(){
		return this.ID;
	}
}

