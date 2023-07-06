package project;

public class LeaveOnRoad implements DiscountStrategy {
	//returns the discount starting from a bike ride 
	public double computeDiscount(){
		return 1.1;
	}
}