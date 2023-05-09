package project;

public class ParkingSlot {
	private static int counter = 0;
	private int id;
	private Bike bike;
	private SlotStatus status;
	
	
	public ParkingSlot(Bike bike, SlotStatus status) {
		super();
		this.id = counter;
		this.bike = bike;
		this.status = status;
		counter++;
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
