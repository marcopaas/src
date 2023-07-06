package project;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	private int id;
	private String name;
	private Location gps;
	private double totalCharge;
	private boolean hasBike; //to check whether the user is currently using a bike or not, if so, he cannot rent another one before returning the first
	//private int nbOfRides;
	//private CreditCard creditCard;
	private Bike bike;
	private BikeRide currentRide;
	private int nbOfRides;
	
	
	
	public int getNbOfRides() {
		return nbOfRides;
	}
	public void setNbOfRides(int nbOfRides) {
		this.nbOfRides = nbOfRides;
	}
	
	public User(String name, Location gps) {
		super();
		UserIDGenerator gen = UserIDGenerator.getInstance();
		this.id = gen.getUserID(); 
		this.name = name;
		this.gps = gps;
		//this.creditCard = creditCard;
		hasBike = false;
		totalCharge = 0;
		nbOfRides = 0;
		this.bike = null;
	}
	public User(String name, Location gps, Bike bike) {
		super();
		UserIDGenerator gen = UserIDGenerator.getInstance();
		this.id = gen.getUserID(); 
		this.name = name;
		this.gps = gps;
		this.bike = bike;
		//this.creditCard = creditCard;
		hasBike = true;
		totalCharge = 0;
		nbOfRides = 1;
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
	
	public Location getGps() {
		return gps;
	}
	public void setGps(Location gps) {
		this.gps = gps;
	}
	
	public double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
	
	public boolean getHasBike() {
		return hasBike;
	}
	public void setHasBike(boolean hasBike) {
		this.hasBike = hasBike;
	}
	
	
	// public int getNbOfRides() {
	// 	return nbOfRides;
	// }
	// public void setNbOfRides(int nbOfRides) {
	// 	this.nbOfRides = nbOfRides;
	// }
	
//	public CreditCard getCreditCard() {
//		return creditCard;
//	}
//	public void setCreditCard(CreditCard creditCard) {
//		this.creditCard = creditCard;
//	}

	public void setBike(Bike bike){
		this.bike = bike;
	}

	public Bike getBike(){
		return this.bike;
	}
	
	public void setCurrentRide(BikeRide ride){
		this.currentRide = ride;
	}

	public BikeRide getCurrentRide(){
		return this.currentRide;
	}
	

	public void rent(){
		boolean validKey = false;
		if(hasBike)
			System.out.println("You should return the bike in use before renting another one.");
		else{
				BikeType type = null;
				System.out.println("Choose the bike type: Electrical or Mechanical");
				do{
					Scanner scanner = new Scanner(System.in);
					String bikeType = scanner.nextLine();
					if(bikeType.equalsIgnoreCase("Electrical"))
						type = BikeType.ELECTRICAL;
					else if(bikeType.equalsIgnoreCase("Mechanical"))
						type = BikeType.MECHANICAL;
					else{
						System.out.println("Kindly enter a valid type: Electrical or Mechanical.");
					}
				}
				while(type == null);
				
				RidePlanner planner = new RidePlanner(new MinDistance());				
				Bike bike = planner.getStart(this.gps, type);

				System.out.println("You can pickup your " + type + " from this location: " + bike.getGps());
				
				System.out.println("Do you want to rent this bike? Yes or No");
				do{
					Scanner scanner = new Scanner(System.in);
					String accept = scanner.nextLine();
					if(accept.equalsIgnoreCase("Yes"))
					{
						validKey = true;
						System.out.println(this.gps == bike.getGps());
						//checks if the user is in the location of the bike, otherwise he cannot rent it
						if(this.gps == bike.getGps()){
							
							System.out.println("The bike is successfully rented.");
							this.hasBike = true;
							this.bike = bike;
							nbOfRides++;
							bike.setReturned(false);
							currentRide = new BikeRide(this, bike, bike.getGps(), null);
							//if the bike is taken from docking station
							if(bike.getStation()!=null)
							{
								bike.getSlot().setStatus(SlotStatus.FREE);
								bike.getStation().setNumberRents(bike.getStation().getNumberRents() + 1);
								bike.setStation(null);
								bike.setSlot(null);
								currentRide.setStartedFromStation(true);
							}
							else{
								//fields are already null
								currentRide.setStartedFromStation(false);
							}

						}
						else{
							System.out.println("You shoud go to the location to be able to rent the bike.");
						}
					}
					else if(accept.equalsIgnoreCase("No")){
						System.out.println("The bike was not rented.");
						validKey = true;
					}
						
					else{
						System.out.println("Enter a valid key: Yes or No");
					}
				}
				while(!validKey);
			}
		}
	
	
	public void simpleRent2(){
		boolean proceed = true;
		if(hasBike)
			System.out.println("You should return the bike in use before renting another one.");
		else{
				BikeType type = BikeType.MECHANICAL;		
				
				RidePlanner planner = new RidePlanner(new MinDistance());				
				Bike bike = planner.getStart(this.gps, type);
				
//				else if(!station.isOnService()) {
//					System.out.println("Station not in service");
//					proceed = false;
				
				if(bike!=null) {
					System.out.println("You can pickup your " + type + " from this location: " + bike.getGps());
					
					System.out.println("The bike is successfully rented.");
					this.hasBike = true;
					this.bike = bike;
					nbOfRides++;
					bike.setReturned(false);
					currentRide = new BikeRide(this, bike, bike.getGps(), null);
					//if the bike is taken from docking station
					if(bike.getStation()!=null)
					{
						bike.getSlot().setStatus(SlotStatus.FREE);
						bike.getStation().setNumberRents(bike.getStation().getNumberRents() + 1);
						bike.setStation(null);
						bike.setSlot(null);
						currentRide.setStartedFromStation(true);
					}
					else{
						//fields are already null
						currentRide.setStartedFromStation(false);
					}
					
				}
				else {
					System.out.println("No bike found");
				}
				

							
			}
		}
	
	
	
	public void simpleRent(int stationId){
		boolean proceed = true;
		boolean stationFound = false;
		DockingStation station = null;
		if(hasBike)
			System.out.println("You should return the bike in use before renting another one.");
		else{
				BikeType type = BikeType.MECHANICAL;
				
				for(DockingStation s : MyVelib.getStations()) {
					if(s.getId() == stationId)
					{
						station = s;
						stationFound = true;
						continue;
					}
						
				}
				
				if(!stationFound){
					System.out.println("Invalid station ID");
					
				}
//				RidePlanner planner = new RidePlanner(new MinDistance());				
//				Bike bike = planner.getStart(this.gps, type);
//				
				else if(!station.isOnService()) {
					System.out.println("Station not in service");
					proceed = false;
				}
				if(station.checkForSpecifiedBike(type)!=null) {
					this.hasBike = true;
					this.bike = new Bike(station.getGps(),type, station,station.checkForSpecifiedBike(type) );
					nbOfRides++;
					bike.setReturned(false);
					currentRide = new BikeRide(this, bike, bike.getGps(), null);
					try {System.out.println("You can pickup your " + type + " from this location: " + bike.getGps());
					bike.getSlot().setStatus(SlotStatus.FREE);
					System.out.println("The bike is successfully rented.");
					
					//if the bike is taken from docking station
					if(bike.getStation()!=null)
					{
						bike.getSlot().setStatus(SlotStatus.FREE);
						bike.getStation().setNumberRents(bike.getStation().getNumberRents() + 1);
						bike.setStation(null);
						bike.setSlot(null);
						currentRide.setStartedFromStation(true);
					}
					else{
						//fields are already null
						currentRide.setStartedFromStation(false);
					}}
					catch(NullPointerException e)
					{
						System.out.println("try again");
					}
					
					
					
				}
				else {
					System.out.println("No bike in this station");
				}
				

							
			}
		}
//	public void simplerent(){
//		if(hasBike)
//			System.out.println("You should return the bike in use before renting another one.");
//		else{	
//			RidePlanner planner = new RidePlanner(new MinDistance());				
//			Bike bike = planner.getStart(this.gps, BikeType.MECHANICAL);
//			System.out.println("The bike is successfully rented.");
//			this.hasBike = true;
//			this.bike = bike;
//			nbOfRides++;
//			bike.setReturned(false);
//			currentRide = new BikeRide(this, BikeType.MECHANICAL, bike.getGps(), null);
//			if(bike.getStation()!=null)
//			{
//				bike.getSlot().setStatus(SlotStatus.FREE);
//				bike.getStation().setNumberRents(bike.getStation().getNumberRents() + 1);
//				bike.setStation(null);
//				bike.setSlot(null);
//				currentRide.setStartedFromStation(true);
//			}
//			else{
//				//fields are already null
//				currentRide.setStartedFromStation(false);
//			}
//			}
//	}
	public Location provideLocation(){
		String startName = "";
		double longitude = 0;
		double latitude = 0;
		Scanner scanner;
		boolean valid = false;
		Location start;
		

			
		do{
			scanner = new Scanner(System.in);
			try{
				startName = scanner.next();
				String l = scanner.next();
				longitude = Double.parseDouble(l);
				String a = scanner.next();
				latitude = Double.parseDouble(l);
				valid = true;
			}
			catch(NumberFormatException exception){
				System.out.println("Enter a valid location");
			}

		start = new Location(startName, longitude, latitude);
		}
		while(!valid);
		
		return start;
	}

	public void plan(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Kindly enter the start location in this format: Name Longitude Latitude");
		Location start = provideLocation();

		System.out.println("Kindly enter the destination in this format: Name Longitude Latitude");
		Location destination = provideLocation();
		
		System.out.println("Enter the bike type: Electrical or Mechanical.");
		BikeType type = null;
		do{
			System.out.println("Choose the bike type: Electrical or Mechanical");
			String bikeType = scanner.nextLine();
			if(bikeType.equalsIgnoreCase("Electrical"))
				type = BikeType.ELECTRICAL;
			else if(bikeType.equalsIgnoreCase("Mechanical"))
				type = BikeType.MECHANICAL;
			else{
				System.out.println("Kindly enter a valid type: Electrical or Mechanical.");
			}
		}
		while(type == null);

		RidePlanner planner = new RidePlanner(new MinDistance());
		System.out.println("You can get your bike from " + planner.getStart(this.gps, type).getGps().toString());
		System.out.println("You can get dock your bike in " + planner.getEnd(destination).toString());
	}

	public void returnBike(){
		boolean validKey = false;
		if(!hasBike)
			System.out.println("You don't have a rented bike to return.");
		else{
			System.out.println("Are you sure you want to return the bike? Yes or No");
			do{
				Scanner scanner = new Scanner(System.in);
				String accept = scanner.nextLine();
				if(accept.equalsIgnoreCase("Yes"))
				{
					validKey = true;
					//checks if the user gps = one of the stations gps
					ArrayList<DockingStation> stations = MyVelib.getStations();
					for(DockingStation s : stations){
						if(s.getGps().distanceTo(this.getBike().getGps()) == 0)
						{
							if(s.isOnService()){
								if(s.checkForEmptySlots()!=null){

									System.out.println("You bike can be successfully returned to the this station.");
									currentRide.setReturnedToStation(true);
									s.setNumberReturns(s.getNumberReturns() + 1);
									hasBike = false;
									bike.setReturned(true);
									s.checkForEmptySlots().setStatus(SlotStatus.OCCUPIED);
									
									//update info before calling the cost
									if(this instanceof UserWithRegistrationCard)
									{
										UserWithRegistrationCard us = (UserWithRegistrationCard)this;
										if(s instanceof PlusStation)
										{
											
											us.setTimeBalance(us.getTimeBalance()+5);
										}
									
										if(currentRide.getDuration() > us.getTimeBalance())
										{
											us.getCurrentRide().setTimeCharged(us.getCurrentRide().getDuration() - us.getTimeBalance());
										}
										else{
											us.getCurrentRide().setTimeCharged(0);
											us.setTimeBalance(us.getTimeBalance()-us.getCurrentRide().getDuration());
										}
									
									}
									
									//calculate the cost of the ride
									System.out.println("You have been charged " + currentRide.getCost());
										

								}
								else System.out.println("No empty slots in this station.");
					
							}
							else System.out.println("The station is out of order.");
					
						}
						else{
							System.out.println("You bike can be successfully returned but you will be extra charged for leaving it on road.");
							currentRide.setReturnedToStation(false);
							hasBike = false;
							bike.setReturned(true);
						}
					}

				}
				else if(accept.equalsIgnoreCase("No")){
					validKey = true;
				}
				
			} while(!validKey);
			
		}
		
	}

	public void simpleReturnBike(){
		
		if(!hasBike)
			System.out.println("You don't have a rented bike to return.");
		else{
				//checks if the user gps = one of the stations gps
				ArrayList<DockingStation> stations = MyVelib.getStations();
				DockingStation exactStation = null;
				for(DockingStation s : stations){
					if(s.getGps().distanceTo(this.getBike().getGps())< 20) exactStation = s; //user close to the station
				}
				if(exactStation!=null && !exactStation.isOnService()) {
					System.out.println("Station not in service");
					exactStation=null;
				}
				if(exactStation!=null) {
					System.out.println("Your bike can be successfully returned to the this station.");
					currentRide.setReturnedToStation(true);
					exactStation.setNumberReturns(exactStation.getNumberReturns() + 1);
					hasBike = false;
					bike.setReturned(true);
					ParkingSlot slot = exactStation.checkForEmptySlots();
					slot.setStatus(SlotStatus.OCCUPIED);
					
					bike.setSlot(slot);
					bike.setStation(exactStation);
					
					//update info before calling the cost
					if(this instanceof UserWithRegistrationCard)
					{
						UserWithRegistrationCard us = (UserWithRegistrationCard)this;
						if(exactStation instanceof PlusStation)
						{
							
							us.setTimeBalance(us.getTimeBalance()+5);
						}
					
						if(currentRide.getDuration() > us.getTimeBalance())
						{
							us.getCurrentRide().setTimeCharged(us.getCurrentRide().getDuration() - us.getTimeBalance());
						}
						else{
							us.getCurrentRide().setTimeCharged(0);
							us.setTimeBalance(us.getTimeBalance()-us.getCurrentRide().getDuration());
						}
					
					}
					
				}
				else{
					System.out.println("You bike can be successfully returned but you will be extra charged for leaving it on road.");
					currentRide.setReturnedToStation(false);
					hasBike = false;
					bike.setReturned(true);
					//update info before calling the cost
					if(this instanceof UserWithRegistrationCard)
					{
						UserWithRegistrationCard us = (UserWithRegistrationCard)this;
						if(exactStation instanceof PlusStation)
						{
							
							us.setTimeBalance(us.getTimeBalance()+5);
						}
					
						if(currentRide.getDuration() > us.getTimeBalance())
						{
							us.getCurrentRide().setTimeCharged(us.getCurrentRide().getDuration() - us.getTimeBalance());
						}
						else{
							us.getCurrentRide().setTimeCharged(0);
							us.setTimeBalance(us.getTimeBalance()-us.getCurrentRide().getDuration());
						}
					
					}
				}
				//calculate the cost of the ride
				System.out.println("You have been charged " + currentRide.getCost());
			}			
		}
		
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gps=" + gps + ", totalCharge=" + totalCharge + ", hasBike="
				+ hasBike + ", bike=" + bike + ", currentRide=" + currentRide + ", nbOfRides=" + nbOfRides + "]";
	}


	// public BikeRide SearchRide(Location start, Location end, BikeType type) {
		
	// 	BikeRide ride = null;
	// 	//check nearest station with required type
	// 	DockingStation s1 = MyVelib.CheckNearestStation(start, type);
	// 	if (s1==null)
	// 		System.out.println("There is no available bike type for your ride");
	// 	else {
	// 			// check nearest destination station
	// 			//check if there is empty place	
	// 			DockingStation s2 = MyVelib.CheckNearestStation(end);
	// 			if(s2==null)
	// 				System.out.println("There is no available empty slot to park your bike");
	// 			ride = new BikeRide(this, type, s1.getGps(), s2.getGps());
	// 			System.out.println("Your ride from " + s1.getGps().toString() + " to " + s2.getGps().toString() + " is available. ");
				
	// 	}		
		
	// 	return ride;
	// }
	
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
	
	
	// public void Quit() {
	// 	MyVelib.removeUser(this);
	// }
	
	
	
	
	
	
}
