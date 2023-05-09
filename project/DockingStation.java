package project;
import java.util.ArrayList;

public abstract class DockingStation {
	private int id;
	private Location gps;
	private boolean onService;
	private ArrayList<ParkingSlot> slots;
	//private Terminal terminal;
	private int numberReturns;
	private int numberRents;
	
	public DockingStation(int id, Location gps, boolean onService, ArrayList<ParkingSlot> slots,
			int numberReturns, int numberRents) {
		super();
		this.id = id;
		this.gps = gps;
		this.onService = onService;
		this.slots = slots;
		//this.terminal = terminal;
		this.numberReturns = numberReturns;
		this.numberRents = numberRents;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getGps() {
		return gps;
	}

	public void setGps(Location gps) {
		this.gps = gps;
	}

	public ArrayList<ParkingSlot> getSlots() {
		return slots;
	}

	public void setSlots(ArrayList<ParkingSlot> slots) {
		this.slots = slots;
	}

//	public Terminal getTerminal() {
//		return terminal;
//	}

//	public void setTerminal(Terminal terminal) {
//		this.terminal = terminal;
//	}

	
	//create a method to check whether a docking station has a specified bike
	public boolean CheckForSpecifiedBike(BikeType type) {
		boolean exists = false;
		BikeType t;
		for(ParkingSlot s : slots)
		{
			if (s.getStatus() == SlotStatus.FREE || s.getStatus() == SlotStatus.OUT_OF_ORDER)
				continue;			
			t = s.getBike().getType();
			if (t!= null && t == type)
			{
				exists = true;
				break;
			}
		}
		return exists;
				
	}
	
	
	public boolean CheckForEmptySlots() {
		boolean exists = false;
		for (ParkingSlot s : slots)
		{
			if (s.getStatus() == SlotStatus.FREE)
			{
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	
	public int getNumberReturns() {
		return numberReturns;
	}

	public void setNumberReturns(int numberReturns) {
		this.numberReturns = numberReturns;
	}

	public int getNumberRents() {
		return numberRents;
	}

	public void setNumberRents(int numberRents) {
		this.numberRents = numberRents;
	}

	public void setOnService(boolean onService) {
		this.onService = onService;
	}
	
	public boolean isOnService() {
		return onService;
	}
}
