package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTest {
	
	@Test //distance  zero
	void testZeroDistance() {
		Location loc1= new Location("1",1,1);
		Location loc2= new Location("2",1,1);
		double distance = loc1.distanceTo(loc2);
		assertTrue(distance == 0);
	}
	
	@Test //distance different from zero
	void testNonZeroDistance() {
		Location loc1= new Location("1",1,1);
		Location loc2= new Location("2",4,4);
		double distance = loc1.distanceTo(loc2);
		assertTrue(distance != 0);
	}
	
	@Test //distance test
	void testDistanceReturnedValue() {
		//miles = 172.367
		//PRINCETON_NJ (40.366633, 74.640832) to ITHACA_NY (42.443087, 76.488707)
		Location loc1= new Location("PRINCETON_NJ",40.366633,74.640832);
		Location loc2= new Location("ITHACA_NY",42.443087,76.488707);
		int distance = (int)loc1.distanceTo(loc2);
		assertTrue(distance == 172);
	}

}
