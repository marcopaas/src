package project;

public class BikeRide {

	private User user;
	//private BikeType type;
	private Location start;
	private Location end;
	private boolean startedFromStation; //used in user.rent()
	private boolean returnedToStation; //used in user.return()
	private Bike bike;
	//private double charge;
	private int duration;
	private int chargedTime; //the cost will be calculated based on this
	
	
	public BikeRide(User user, Bike bike, Location start, Location end) {
		super();
		this.user = user;
		this.bike = bike;
		this.start = start;
		this.end = end;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//	public BikeType getType() {
//		return type;
//	}
//	public void setType(BikeType type) {
//		this.type = type;
//	}
	
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
	
	public void setStartedFromStation(boolean b){
		startedFromStation = b;
	}

	public boolean getStartedFromStation(){
		return startedFromStation;
	}

	public void setReturnedToStation(boolean b){
		returnedToStation = b;
	}

	public boolean getReturnedToStation(){
		return returnedToStation;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int minutes) {
		this.duration = minutes;
	}
	
//	public double getCharge() {
//		return charge;
//	}
//	public void setCharge(double charge) {
//		this.charge = charge;
//	}

	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public CostCalculator strategyAndDiscountSelector(){
		CostCalculator calculator = new CostCalculator();
		if(user instanceof UserWithRegistrationCard){
			UserWithRegistrationCard usR = (UserWithRegistrationCard)user;
			if(usR.getRegistrationCard() instanceof VlibreCard){
				if(bike.getType() == BikeType.ELECTRICAL){
					calculator.setCostStrategy(new VlibElecStrategy());
				}
				//if bike mecha
				else{
					calculator.setCostStrategy(new VlibMechStrategy());
				}
			}
			//if card vmax
			else{
				calculator.setCostStrategy(new VmaxStrategy());
			}
		}
		//user with no reg card
		else{
			if(bike.getType() == BikeType.ELECTRICAL){
				calculator.setCostStrategy(new NoRegistrationElecStrategy());
			}
			else{
				calculator.setCostStrategy(new NoRegistrationMechStrategy());
			}

		}

		if(!returnedToStation){
			//malus
			calculator.setDiscountStrategy(new LeaveOnRoad());
		}
		else{
			if(!startedFromStation){
				//discount
				calculator.setDiscountStrategy(new ReturnedToStation());
			}
			else{
				//normal
				calculator.setDiscountStrategy(new NoDiscount());
			}
		}
		return calculator;
	}

	public void setTimeCharged(int min){
		chargedTime = min;
	}

	public double getCost(){
		System.out.println();
		return this.strategyAndDiscountSelector().getCost(chargedTime);
	}

}
