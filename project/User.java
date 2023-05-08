package project;

public class User {
	private int id;
	private String name;
	private Location position;
	private double totalCharge;
	private boolean bike_in_use; //to check whether the user is currently using a bike or not, if so, he cannot rent another one before returning the first
	private int totalTime;
	private int nbOfRides;
	private CreditCard creditCard;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Location getPosition() {
		return position;
	}
	public void setPosition(Location position) {
		this.position = position;
	}
	
	public double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
	
	public boolean isBike_in_use() {
		return bike_in_use;
	}
	public void setBike_in_use(boolean bike_in_use) {
		this.bike_in_use = bike_in_use;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public int getNbOfRides() {
		return nbOfRides;
	}
	public void setNbOfRides(int nbOfRides) {
		this.nbOfRides = nbOfRides;
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	
	
	
}
