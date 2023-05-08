package project;

public class ParkingSlot {
	private int id;
	private Bike bike;
	private SlotStatus status;
	
	
	public ParkingSlot(int id, Bike bike, SlotStatus status) {
		super();
		this.id = id;
		this.bike = bike;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SlotStatus getStatus() {
		return status;
	}

	public void setStatus(SlotStatus status) {
		this.status = status;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public boolean isFree() {
		if (status == SlotStatus.FREE) return true;
		else return false;
	}
	
}
