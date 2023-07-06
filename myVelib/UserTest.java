package project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {
	private static User user;
	private static User usernobike;
	private static Location loc1;
	private static Bike b1;
	@BeforeAll
    public static void setUp() {
		MyVelib.setup("myvelib", 10, 10, 100, 50);
		loc1 = new Location("1",20,20);
		b1 = new Bike(loc1, BikeType.ELECTRICAL);
		user = new User("Marco", loc1, b1);
		usernobike = new User("layal",loc1);
		user.simpleRent2();
		usernobike.simpleRent2();
    }

//	@Test
//	void testRent() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSimpleRentUserHasBike() {
		assertTrue(user.getHasBike());
	}
	@Test
	void testSimpleRentUserHasBike1() {
		assertTrue(user.getNbOfRides()==1);
	}
	@Test
	void testSimpleRentUserHasBike2() {
		assertTrue(user.getBike() != null);
	}
	@Test
	void testSimpleRentUserNoBike() {
		assertTrue(usernobike.getNbOfRides()==1);
	}
	@Test
	void testSimpleRentUserNoBike1() {
		assertTrue(usernobike.getHasBike());
	}
	@Test
	void testSimpleRentUserNoBike2() {
		assertTrue(user.getBike() != null);
	}

//	@Test
//	void testProvideLocation() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testPlan() {
//		
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testReturnBike() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSimpleReturnBikeOnRoad() {
//		
//		fail("Not yet implemented");
//	}
	@Test
	void testSimpleReturnBikeStation() {
		usernobike.simpleRent2();
		Location loc3 = new Location("",31.622776601683793,10.0);
		BikeRide ride = new BikeRide(usernobike, b1, loc1, loc3);
		b1.setGps(new Location("",31.622776601683793,10.0));
		ride.setTimeCharged(60);
		usernobike.setCurrentRide(ride);
		usernobike.simpleReturnBike();
		assertTrue(ride.getCost()==1.8); //discount applied because leaved on station
	}
//	@Test
//	void testSimpleReturnBikeStationBikeInStation() {
//		usernobike.simpleRent();
//		//Location loc3 = new Location("",31.622776601683793,10.0);
//		b1.setGps(loc1);
//		BikeRide ride = new BikeRide(usernobike, b1, loc1, loc1);
//		ride.setTimeCharged(60);
//		usernobike.setCurrentRide(ride);
//		usernobike.simpleReturnBike();
//		assertTrue(ride.getCost()==2.2); //fee applied because leaved on road
//	
//	}

}
