package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoRegistrationElecStrategyTest {

	@Test
	void testComputeCostGreaterThanHour() {
		CostStrategy cs = new NoRegistrationElecStrategy();
		double cost = cs.computeCost(70);
		double result = 2*70.0/60;
		assertTrue(cost==result);
	}
	
	@Test
	void testComputeCostLowerThanHour() {
		CostStrategy cs = new NoRegistrationElecStrategy();
		double cost = cs.computeCost(50);
		double result = 2*50.0/60;
		assertTrue(cost==result);
	}
	@Test
	void testComputeCostEqualHour() {
		CostStrategy cs = new NoRegistrationElecStrategy();
		double cost = cs.computeCost(60);
		double result = 2*60.0/60;
		assertTrue(cost==result);
	}

}
