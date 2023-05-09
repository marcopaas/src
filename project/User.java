package project;

import java.util.ArrayList;

public class User {
	private static int lastId = 0;
	private int id;
	private String name;
	private Location position;
	private double totalCharge;
	private boolean bike_in_use; //to check whether the user is currently using a bike or not, if so, he cannot rent another one before returning the first
	private int totalTime;
	private int nbOfRides;
	private CreditCard creditCard;
	
	
	
	
	public User(String name, Location position, CreditCard creditCard) {
		super();
		this.name = name;
		this.position = position;
		this.creditCard = creditCard;
		bike_in_use = false;
		totalTime = 0;
		nbOfRides = 0;
		lastId += 1;
		id = lastId;
		
	}

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
	
	public BikeRide SearchRide(Location start, Location end, BikeType type) {
		
		BikeRide ride = null;
		//check nearest station with required type
		DockingStation s1 = MyVelib.CheckNearestStation(start, type);
		if (s1==null)
			System.out.println("There is no available bike type for your ride");
		else {
				// check nearest destination station
				//check if there is empty place	
				DockingStation s2 = MyVelib.CheckNearestStation(end);
				if(s2==null)
					System.out.println("There is no available empty slot to park your bike");
				ride = new BikeRide(this, type, s1.getGps(), s2.getGps());
				System.out.println("Your ride from " + s1.getGps().toString() + " to " + s2.getGps().toString() + " is available. ");
				
		}		
		
		return ride;
	}
	
//	public void BookRide(BikeRide ride) {
//		
//		
//	}
//	
//	public void BookRide(Location start, Location end, BikeType type) {
//		
//		
//	
//	}
	
	
	public void Quit() {
		MyVelib.removeUser(this);
	}
	
	
	
	
	
	
}
