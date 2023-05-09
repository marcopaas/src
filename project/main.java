package project;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		MyVelib.addUser(new User("Pier", new Location("piazza",1,1),new CreditCard(10,"Pier")));
		MyVelib.addUser(new User("Luca", new Location("piazza",2,3)),new CreditCard(12,"Luca"));
		MyVelib.addUser(new User("Gian", new Location("piazza",1,3)),new CreditCard(11,"Gian"));
		
		ArrayList<ParkingSlot> slots = new ArrayList();
		slots.add(null);
		slots.add(null);
		slots.add(null);
		
		MyVelib.addStation(null);
		
	}
}
