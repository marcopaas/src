package project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class MyVelib {
	private static String name;
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<DockingStation> stations = new ArrayList<DockingStation>();
	private static ArrayList<Bike> bikes = new ArrayList<Bike>();
	
	//maybe add arraylist of current bikerides
	
	public static ArrayList<User> getUsers() {
		return users;
	}
	public static ArrayList<DockingStation> getStations() {
		return stations;
	}
	public static ArrayList<Bike> getBikes() {
		return bikes;
	}
	public static void addUser(User users1) {
		users.add(users1);
	}
	public static void addStation(DockingStation stations1) {
		stations.add(stations1);
	}
	public static void addBike(Bike b) {
		bikes.add(b);
	}

	public static void removeUser(User user) {
		users.remove(user);
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		MyVelib.name = name;
	}
	
	public static void setup(String velibNetworkName, int numStations, int numParkingSlots, int sideLength, int numBikes) {
		MyVelib.name = velibNetworkName;
		
        // Calculate the distance between two consecutive stations
		double distanceBetweenStations = sideLength / Math.sqrt(numStations);
		
		// Initialize random number generator
        Random random = new Random();
        
        int numTotSlots = numStations*numParkingSlots;
        
        boolean[][] array = new boolean[numStations][numParkingSlots];
        
        int count = 0;
        while (count < numBikes) {
            int i = random.nextInt(numStations);
            int j = random.nextInt(numParkingSlots);
            if (!array[i][j]) {
                array[i][j] = true;
                count++;
            }
        }
        
        
		for (int i = 0; i < numStations; i++) {
            // Calculate the x and y coordinates of the station
            double x = (i % Math.sqrt(numStations)) * distanceBetweenStations;
            double y = (i / Math.sqrt(numStations)) * distanceBetweenStations;
            
            // Create the station and add it to the map
            Location loc = new Location("Station"+i,x,y);
            StdStation stdStation = new StdStation(loc);
            stations.add(stdStation);
            
            //lets add the slots
            for (int ii = 0; ii < numParkingSlots; ii++) {
            	ParkingSlot slot = new ParkingSlot(null, SlotStatus.FREE);
            	stdStation.addSlot(slot);
            	
            	//add bike 
            	if(array[i][ii]==true) {
            		boolean sel = random.nextBoolean();
            		BikeType b;
            		//if(sel == true) 
            			b = BikeType.MECHANICAL;
            		// else b = BikeType.ELECTRICAL;
            		Bike bike = new Bike(loc,b,stdStation,slot);
            		slot.setBike(bike);
            		slot.setStatus(SlotStatus.OCCUPIED);
            		MyVelib.addBike(bike);
            	}
            }
        }
	}
	
	public static ArrayList<DockingStation> sort(String s){
		if(s.equals("leastOccupied")) {
			Comparator<DockingStation> comp = new LeastOccupiedComparator();
			ArrayList<DockingStation> sorted = new ArrayList<DockingStation>();
			sorted = stations;
			Collections.sort(sorted, comp);
			return sorted;
		}
		else if(s.equals("mostUsed")) {
			Comparator<DockingStation> comp = new MostUsedComparator();
			ArrayList<DockingStation> sorted = new ArrayList<DockingStation>();
			sorted = stations;
			Collections.sort(sorted, comp);
			return sorted;
		}
		else {
			System.out.println("Invalid sorting policy. it can either be leastOccupied or mostUsed");
		}
		return stations;
	}
	
	@Override
	public String toString() {
		return "Users : " + users + "\n Stations : " + stations + "\n Bikes :" + bikes;
	}
}
