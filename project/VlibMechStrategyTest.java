package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VlibMechStrategyTest {

	@Test
	void testComputeCost() {
		CostStrategy cs = new VlibMechStrategy();
		double cost = cs.computeCost(70);
		double result = 1.0/6;
		assertTrue(cost==result);
	}
	@Test
	void testComputeCostLowerThanHour() {
		CostStrategy cs = new VlibMechStrategy();
		double cost = cs.computeCost(50);
		double result = 0;
		assertTrue(cost==result);
	}
	@Test
	void testComputeCostEqualHour() {
		CostStrategy cs = new VlibMechStrategy();
		double cost = cs.computeCost(60);
		double result = 0;
		assertTrue(cost==result);
	}

}
