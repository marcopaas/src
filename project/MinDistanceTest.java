package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class MinDistanceTest {
	private static RidePlanner planner;
	private static Location loc1;
	private static Location loc2;
	private static Location loc3;
	private static Location loc4;
	private static Bike b1;
	private static Bike b2;
	private static Bike b3;
	
	private static DockingStation st1;
	private static DockingStation st2;
	private static DockingStation st3;
	private static DockingStation st4;
	
	@BeforeAll
    public static void setUp() {
		loc1 = new Location("1",1,1);
		loc2 = new Location("2",4,4);
		loc3 = new Location("3",6,6);
		loc4 = new Location("4",4,5);
		b1 = new Bike(loc1, BikeType.ELECTRICAL);
		b2 = new Bike(loc2, BikeType.ELECTRICAL);
		b3 = new Bike(loc1, BikeType.MECHANICAL);
		MyVelib.addBike(b1);
		MyVelib.addBike(b2);
		MyVelib.addBike(b3);
		
		planner = new RidePlanner(new MinDistance());
		
		st1 = new StdStation(loc1);
		st1.addSlot(new ParkingSlot(b1, SlotStatus.OCCUPIED));
		st1.addSlot(new ParkingSlot(null, SlotStatus.FREE));
		
		st2 = new PlusStation(loc2);
		st2.addSlot(new ParkingSlot(null, SlotStatus.FREE));
		
		st3 = new PlusStation(loc3);
		st3.setOnService(false);
		st3.addSlot(new ParkingSlot(null, SlotStatus.FREE));
		
		st4 = new PlusStation(loc4);
		st4.addSlot(new ParkingSlot(null, SlotStatus.OCCUPIED));
		st4.addSlot(new ParkingSlot(null, SlotStatus.OUT_OF_ORDER));
		
		MyVelib.addStation(st1);
		MyVelib.addStation(st2);
		MyVelib.addStation(st3);

		
    }

	@Test
	void testGetBikeStart1() {
		Bike b4 = planner.getStart(new Location("userloc",1 ,2), BikeType.MECHANICAL);
		assertEquals(b4, b3);
	}
	@Test
	void testGetBikeStart2() {
		Bike b5 = planner.getStart(new Location("userloc",1 ,2), BikeType.ELECTRICAL);
		assertEquals(b5, b1);
	}
	@Test
	void testGetBikeStart3() {
		Bike b4 = planner.getStart(new Location("userloc",3 ,3), BikeType.ELECTRICAL);
		assertEquals(b4, b2);
	}

	@Test //check if min distance works
	void testGetStationEnd() {
		Location end = planner.getEnd(loc1);
		assertEquals(end, loc1);
	}
	@Test //check if min distance works
	void testGetStationEnd2() {
		Location end = planner.getEnd(loc2);
		assertEquals(end, loc2);
	}
	@Test //check if station not working is skipped
	void testGetStationEnd3(){
		Location end = planner.getEnd(loc3);
		assertEquals(end, loc2);
	}
	@Test //check if slot occupied is skipped
	void testGetStationEnd4(){
		Location end = planner.getEnd(loc4);
		assertEquals(end, loc2);
	}
//	@Test //
//	void testGetStationEnd5(){
//		Location end = planner.getEnd(null);
//		assertEquals(end, loc2);
//	}

}
