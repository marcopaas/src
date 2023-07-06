package project;

public class NoDiscount implements DiscountStrategy {
	//returns the discount starting from a bike ride 
	public double computeDiscount(){
		return 1;
	}
}