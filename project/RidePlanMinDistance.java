package project;

import java.util.ArrayList;

public class RidePlanMinDistance {
	public RidePlanMinDistance(Location start, Location destination, BikeType type ) {
		
		// TODO Auto-generated constructor stub
		
	}
	
	public Location checkMinDist(Location startOrDest)
	{
		
		ArrayList<DockingStation> stations = MyVelib.getStations();
		for(DockingStation s : stations) {
			// to be completed
			
		}
		return new Location();
		
	}
	
	public boolean startHasDesiredBike(BikeType type) {
		return false;
		// to be complete
	}
	
	public boolean endHasParkingSpot(Location dest) {
		
		return false;
	}
}
