package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BikeRideTest {
	private static User user1;
	private static User user2;
	private static User user3;
	
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
		b1 = new Bike(loc1, BikeType.ELECTRICAL);
		b2 = new Bike(loc2, BikeType.ELECTRICAL);
		b3 = new Bike(loc1, BikeType.MECHANICAL);
		
		user1 = new User("Marco", loc1);
		
		CardFactory factory = new CardFactory();
		RegistrationCard vmax = factory.createCard("vmax", "Layal");
		user2 = new UserWithRegistrationCard("Layal", loc2, vmax);
		
		RegistrationCard vlibre = factory.createCard("vlibre", "Piero");
		user3 = new UserWithRegistrationCard("Layal", loc2, vlibre);
		
		MyVelib.addUser(user1);
		MyVelib.addUser(user2);
    }
	@Test
	void testStrategyAndDiscountSelectorNoRegistrationElec() {
		// user with no registration, electrical
		BikeRide br = new BikeRide(user1, b1, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getCostStrategy() instanceof NoRegistrationElecStrategy);
	}
	@Test
	void testStrategyAndDiscountSelectorNoDiscountElec() {
		// user with no registration, electrical
		BikeRide br = new BikeRide(user1, b1, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getDiscountStrategy() instanceof NoDiscount);
	}
	@Test
	void testStrategyAndDiscountSelectorNoRegistrationMech() {
		// user with no registration, mechanical
		BikeRide br = new BikeRide(user1, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getCostStrategy() instanceof NoRegistrationMechStrategy);
	}
	@Test
	void testStrategyAndDiscountSelectorNoDiscountMech() {
		// user with no registration, mechanical
		BikeRide br = new BikeRide(user1, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getDiscountStrategy() instanceof NoDiscount);
	}
	@Test
	void testStrategyAndDiscountSelectorDiscountMech() {
		// user with no registration, mechanical
		BikeRide br = new BikeRide(user1, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getDiscountStrategy() instanceof NoDiscount);
	}
	@Test
	void testStrategyAndDiscountSelectorRegistrationMechVmax() {
		// user with registration vmax , mechanical
		BikeRide br = new BikeRide(user2, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getCostStrategy() instanceof VmaxStrategy);
	}
	@Test
	void testStrategyAndDiscountSelectorDiscountMechVmax() {
		// user with registration vmax , mechanical
		BikeRide br = new BikeRide(user2, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getDiscountStrategy() instanceof NoDiscount);
	}
	@Test
	void testStrategyAndDiscountSelectorDiscountLeaveOnRoad() {
		// user with registration vmax , mechanical
		BikeRide br = new BikeRide(user2, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(false);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getDiscountStrategy() instanceof LeaveOnRoad);
	}
	@Test
	void testStrategyAndDiscountSelectorDiscountReturned() {
		// user with registration vmax , mechanical
		BikeRide br = new BikeRide(user2, b3, loc1, loc2);
		br.setStartedFromStation(false);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getDiscountStrategy() instanceof ReturnedToStation);
	}
	
	@Test
	void testStrategyAndDiscountSelectorVlibMechStrategy() {
		// user with registration vlib , mechanical
		BikeRide br = new BikeRide(user3, b3, loc1, loc2);
		br.setStartedFromStation(false);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getCostStrategy() instanceof VlibMechStrategy);
	}
	@Test
	void testStrategyAndDiscountSelectorVlibElecStrategy() {
		// user with registration vlib , elec
		BikeRide br = new BikeRide(user3, b2, loc1, loc2);
		br.setStartedFromStation(false);
		br.setReturnedToStation(true);
		
		CostCalculator calculator = br.strategyAndDiscountSelector();
		assertTrue(calculator.getCostStrategy() instanceof VlibElecStrategy);
	}

	@Test
	void testGetCost() {
		//we tried also this method since is calling all the other methods
		BikeRide br = new BikeRide(user1, b3, loc1, loc2);
		br.setStartedFromStation(true);
		br.setReturnedToStation(true);
		br.setTimeCharged(60);
		double cost = br.getCost();
		assertTrue(cost == 1);
	}

}
