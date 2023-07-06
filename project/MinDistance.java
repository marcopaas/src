package project;

import java.util.ArrayList;

public class MinDistance implements RidePlanning{
	
	public MinDistance() {
		super();
	}
	public Bike getBikeStart(Location loc, BikeType type){
		ArrayList<Bike> bikes = MyVelib.getBikes();
		Bike closestBike = null;
		double distance = 0;
		boolean empty =true; // initially closestBike is null;
		for(Bike b : bikes) 
		{
			if(b.getType()!=type || b.isReturned() == false)
				continue;
			else{
					Location bikeLoc = b.getGps();
					if(empty == true){
						closestBike = b;
						distance = loc.distanceTo(bikeLoc);
						empty = false;
					}
					else{
						if(loc.distanceTo(bikeLoc)<distance){
							closestBike = b;
							distance = loc.distanceTo(bikeLoc);
							
						}
					}
				}
			
		}
		return closestBike;
	}
	public DockingStation getStationEnd(Location loc){
		ArrayList<DockingStation> stations = MyVelib.getStations();
		//System.out.println(MyVelib.getStations());
		DockingStation closestStation = null;
		double distance= 0;
		boolean empty = true;
		for(DockingStation s : stations){
			if(s.isOnService()==false || s.checkForEmptySlots() == null)
				continue;
			else{
					Location stationLoc = s.getGps();
					if(empty == true){
						closestStation = s;
						distance = loc.distanceTo(stationLoc);
						empty = false;
					}
					else{
						if(loc.distanceTo(stationLoc)<distance){
							closestStation = s;
							distance = loc.distanceTo(stationLoc);
							
						}
					}
			}
		}

	return closestStation;


	}

	/* public Location checkMinDist(Location startOrDest)
	{
		
		ArrayList<DockingStation> stations = MyVelib.getStations();
		for(DockingStation s : stations) {
			// to be completed
			
		}
		return new Location("", 0, 0);
		
	}
	
	public boolean startHasDesiredBike(BikeType type) {
		return false;
		// to be complete
	}
	
	public boolean endHasParkingSpot(Location dest) {
		
		return false;
	} */
}
