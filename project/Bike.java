package project;

public class Bike {
	@Override
	public String toString() {
		return "Bike [id=" + id + ", gps=" + gps + ", type=" + type + ", returned=" + returned + ", station=" + station
				+ ", slot=" + slot + "]";
	}

	private int id;
	private Location gps;
	private BikeType type;
	private boolean returned;
	private DockingStation station;
	private ParkingSlot slot;
	
	public Bike(Location gps, BikeType type) {
		super();
		BikeIDGenerator gen = BikeIDGenerator.getInstance();
		this.id = gen.getBikeID();
		this.gps = gps;
		this.type = type;
		this.returned = true;
	}
	public Bike(Location gps, BikeType type, DockingStation station, ParkingSlot slot) {
		super();
		BikeIDGenerator gen = BikeIDGenerator.getInstance();
		this.id = gen.getBikeID();
		this.gps = gps;
		this.type = type;
		this.returned = true;
		this.station = station;
		this.slot = slot;
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

	public BikeType getType() {
		return type;
	}

	public void setType(BikeType type) {
		this.type = type;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public DockingStation getStation() {
		return station;
	}

	public void setStation(DockingStation station) {
		this.station = station;
	}

	public ParkingSlot getSlot() {
		return slot;
	}

	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
	}
	
}
