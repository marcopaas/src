package project;

public class BikeRide {

	private User user;
	private BikeType type;
	private Location start;
	private Location end;
	
	
	
	public BikeRide(User user, BikeType type, Location start, Location end) {
		super();
		this.user = user;
		this.type = type;
		this.start = start;
		this.end = end;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public BikeType getType() {
		return type;
	}
	public void setType(BikeType type) {
		this.type = type;
	}
	
	public Location getStart() {
		return start;
	}
	public void setStart(Location start) {
		this.start = start;
	}
	
	public Location getEnd() {
		return end;
	}
	public void setEnd(Location end) {
		this.end = end;
	}
	
	
	//maybe this should be removed and add to the user a function to plan a ride and book a ride and then add arraylist of bikerides in myvelib
}
