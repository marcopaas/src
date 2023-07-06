package project;

import java.util.ArrayList;

public interface RidePlanning {
	public Bike getBikeStart(Location loc, BikeType type);
	public DockingStation getStationEnd(Location loc);
}
