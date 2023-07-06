package project;
import java.util.ArrayList;

public abstract class DockingStation {

	private int numberReturns;
	private int numberRents;
	private int id;
	private Location gps;
	private boolean onService;
	private ArrayList<ParkingSlot> slots = new ArrayList<ParkingSlot>();
	//private Terminal terminal;
	
	public DockingStation(Location gps) {
		super();
		StationIDGenerator gen = StationIDGenerator.getInstance();
		this.id = gen.getStationID();
		this.gps = gps;
		this.onService = true;
		//this.slots = slots;
		//this.terminal = terminal;
		//this.numberReturns = 0;
		//this.numberRents = 0;
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

	public void addSlot(ParkingSlot slot) {
		slots.add(slot);
	}

//	public Terminal getTerminal() {
//		return terminal;
//	}

//	public void setTerminal(Terminal terminal) {
//		this.terminal = terminal;
//	}

	
	//create a method to check whether a docking station has a specified bike
	public ParkingSlot checkForSpecifiedBike(BikeType type) {
		ParkingSlot slot = null;
		BikeType t;
		for(ParkingSlot s : slots)
		{
			if (s.getStatus() == SlotStatus.FREE || s.getStatus() == SlotStatus.OUT_OF_ORDER)
				continue;			
			t = s.getBike().getType();
			if (t!= null && t == type)
			{
				slot = s;
				break;
			}
		}
		return slot;
				
	}
	
	
	public ParkingSlot checkForEmptySlots() {
		boolean exists = false;
		for (ParkingSlot s : slots)
		{
			if (s.getStatus() == SlotStatus.FREE)
			{
				return s;
			}
		}
		return null;
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
	
	@Override
	public String toString() {
		return "DockingStation [numberReturns=" + numberReturns + ", numberRents=" + numberRents + ", id=" + id
				+ ", gps=" + gps + ", onService=" + onService + "]";
	}
}
