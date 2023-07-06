//package project;
//
//import java.util.ArrayList;
//
//public class main {
//	public static void main(String[] args) {
//		//MyVelib.addUser(new User("Pier", new Location("piazza",1,1),new CreditCard(10,"Pier")));
//		//MyVelib.addUser(new User("Luca", new Location("piazza",2,3),new CreditCard(12,"Luca")));
//		//MyVelib.addUser(new User("Gian", new Location("piazza",1,3),new CreditCard(11,"Gian")));
//		
//		//ArrayList<ParkingSlot> slots = new ArrayList();
//		//slots.add(null);
//		//slots.add(null);
//		//slots.add(null);
//		
//		Location loc1 = new Location("1",1,1);
//		Location loc2 = new Location("2",4,4);
//		
//		Bike b1 = new Bike(loc1, BikeType.MECHANICAL);
//		Bike b2 = new Bike(loc2, BikeType.ELECTRICAL);
//		
//		MyVelib.addBike(b1);
//		MyVelib.addBike(b2);
//		
//		DockingStation st1 = new StdStation(loc1);
//		st1.addSlot(new ParkingSlot(b1, SlotStatus.OCCUPIED));
//		st1.addSlot(new ParkingSlot(null, SlotStatus.FREE));
//		
//		DockingStation st2 = new PlusStation(loc2);
//		st2.addSlot(new ParkingSlot(b2, SlotStatus.FREE));
//		
//		MyVelib.addStation(st1);
//		MyVelib.addStation(st2);
//		
//		RidePlanner planner = new RidePlanner(new MinDistance());
//		
//		//getEnd will return the closest Station having free parking slots, checking in the stations of velib
//		Location end = planner.getEnd(new Location("userloc",1,1));
//		
//		System.out.println(end.toString());
//	}
//}
