package project;

public class ReturnedToStation implements DiscountStrategy {
	//returns the discount starting from a bike ride 
	public double computeDiscount(){
		return 0.9;
	}
}