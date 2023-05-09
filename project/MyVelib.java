package project;
import java.util.ArrayList;

public abstract class MyVelib{
	private static ArrayList<User> users;
	private static ArrayList<DockingStation> stations;
	
	//maybe add arraylist of current bikerides
	
	public static ArrayList<User> getUsers() {
		return users;
	}
	public static void addUser(User users1) {
		users.add(users1);
	}
	public static ArrayList<DockingStation> getStations() {
		return stations;
	}
	public static void addStation(DockingStation stations1) {
		stations.add(stations1);
	}
	
	//add user
	
	//add station
	
	
	
}
