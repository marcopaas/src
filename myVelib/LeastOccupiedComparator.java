package project;

import java.util.Comparator;

public class LeastOccupiedComparator implements Comparator<DockingStation> {
	
	public int compare(DockingStation s1, DockingStation s2)
	{
		int differenceRentsReturns1 = s1.getNumberRents()-s1.getNumberReturns();
		int differenceRentsReturns2 = s2.getNumberRents() - s2.getNumberReturns();
		return differenceRentsReturns1-differenceRentsReturns2;
	}
}
