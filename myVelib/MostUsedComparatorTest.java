package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MostUsedComparatorTest {
	private static Location loc1;
	private static Location loc2;
	
	private static DockingStation st1;
	private static DockingStation st2;

	@BeforeAll
    public static void setUp() {
		loc1 = new Location("1",1,1);
		loc2 = new Location("2",4,4);
		st1 = new StdStation(loc1);
		st2 = new PlusStation(loc2);
		st1.setNumberRents(45);
		st1.setNumberReturns(22);
		st2.setNumberRents(30);
		st2.setNumberReturns(10);
    }
	
	@Test
	void testCompare() {
		MostUsedComparator comp = new MostUsedComparator();
		assertTrue(comp.compare(st1, st2)>=0);
	}
	@Test
	void testCompare1() {
		MostUsedComparator comp = new MostUsedComparator();
		assertTrue(comp.compare(st2, st1)<=0);
	}
	@Test
	void testCompareEqual() {
		st1.setNumberRents(30);
		st1.setNumberReturns(10);
		st2.setNumberRents(30);
		st2.setNumberReturns(10);
		MostUsedComparator comp = new MostUsedComparator();
		assertTrue(comp.compare(st1, st2)==0);
	}

}
