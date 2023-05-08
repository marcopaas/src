package project;

public class Bike {
	private int id;
	private Location gps;
	private BikeType type;
	private boolean returned;
	
	public Bike(int id, Location gps, BikeType type, boolean returned) {
		super();
		this.id = id;
		this.gps = gps;
		this.type = type;
		this.returned = returned;
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
	
}
