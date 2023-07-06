package project;

public class CostCalculator {
	private CostStrategy costStrategy;
	private DiscountStrategy discountStrategy;
	public CostCalculator() {
		this.costStrategy = null;
		this.discountStrategy = null;
	}
	public CostCalculator(CostStrategy costStrategy, DiscountStrategy discountStrategy) {
		this.costStrategy = costStrategy;
		this.discountStrategy = discountStrategy;
	}
	public double getCost(int minutes){
		return costStrategy.computeCost(minutes)*discountStrategy.computeDiscount();
	}
	public void setCostStrategy(CostStrategy cs){
		this.costStrategy = cs;
	}

	public void setDiscountStrategy(DiscountStrategy ds){
		this.discountStrategy = ds;
	}
	public CostStrategy getCostStrategy() {
		return costStrategy;
	}
	public DiscountStrategy getDiscountStrategy() {
		return discountStrategy;
	}
}
