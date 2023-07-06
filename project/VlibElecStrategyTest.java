package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VlibElecStrategyTest {

	@Test
	void testComputeCostEqualHour() {
		CostStrategy cs = new VlibElecStrategy();
		double cost = cs.computeCost(60);
		double result = 1.0;
		assertTrue(cost==result);
	}
	@Test
	void testComputeCostLowerThanHour() {
		CostStrategy cs = new VlibElecStrategy();
		double cost = cs.computeCost(50);
		double result = 50.0/60;
		assertTrue(cost==result);
	}
	@Test
	void testComputeCostGreaterThanHour() {
		CostStrategy cs = new VlibElecStrategy();
		double cost = cs.computeCost(70);
		double result = 1.0+10.0*2/60;
		assertTrue(cost==result);
	}

}
