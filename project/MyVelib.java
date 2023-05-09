package project;
import java.util.ArrayList;
import java.util.HashMap;

<<<<<<< HEAD
public abstract class MyVelib {

	
	
	
	
=======
public abstract class MyVelib{
>>>>>>> ea412527c47e30ac584971e97b4caa66b9937762
	private static ArrayList<User> users;
	private static ArrayList<DockingStation> stations;
	
	//maybe add arraylist of current bikerides
	
	public static ArrayList<User> getUsers() {
		return users;
	}
<<<<<<< HEAD

	public static ArrayList<DockingStation> getStations() {
		return stations;
	}

	
//	public static HashMap<DockingStation, Double> SortStations(Location loc){
//		
//		HashMap<DockingStation, Double> stationsToBeSorted = new HashMap<DockingStation, Double>();
//			for(DockingStation s : stations)
//			{
//				stationsToBeSorted.put(s, loc.)
//			}
//		return stationsToBeSorted;
//	}
	
	//to check the nearest starting pt
	public static DockingStation CheckNearestStation(Location loc, BikeType type) {
		DockingStation nearest = null;
		double distance = -1;
		
		for(DockingStation s : stations) {
			if (s.isOnService() && s.CheckForSpecifiedBike(type))
			{
				Location l = s.getGps();
				double d = loc.distanceTo(l);
				if(distance == -1)
				{
					// can we set them equal??
					nearest = s;
					distance = d;
				}
					
				else if(d<distance && s.CheckForSpecifiedBike(type)) {
					distance = d;
					nearest = s;
					
				}
			}
			
		}
		return nearest;
=======
	public static void addUser(User users1) {
		users.add(users1);
	}
	public static ArrayList<DockingStation> getStations() {
		return stations;
	}
	public static void addStation(DockingStation stations1) {
		stations.add(stations1);
>>>>>>> ea412527c47e30ac584971e97b4caa66b9937762
	}
	
	//to check the nearest destination
	public static DockingStation CheckNearestStation(Location loc) {
		DockingStation nearest = null;
		double distance = -1;
		
		for(DockingStation s : stations) {
			if (s.isOnService() && s.CheckForEmptySlots())
			{
				Location l = s.getGps();
				double d = loc.distanceTo(l);
				if(distance == -1)
				{
					// can we set them equal??
					nearest = s;
					distance = d;
				}
					
				else if(d<distance && s.CheckForEmptySlots())
				{
					distance = d;
					nearest = s;
					
				}
			}
			
		}
		return nearest;
	}
	
	
	public static DockingStation CheckNearestStation(Location loc, ArrayList<DockingStation> stationsNotContainingType) {
		
		return null;
	}

	
	public static void addUser(User users1) {
		users.add(users1);
	}
	
	public static void addStation(DockingStation stations1) {
		stations.add(stations1);
	}
	
	
	public static void removeUser(User user) {
		users.remove(user);
	}
	
	
}
