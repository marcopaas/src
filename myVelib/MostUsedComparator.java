package project;

import java.util.Comparator;

public class MostUsedComparator implements Comparator<DockingStation> {

		public int compare(DockingStation s1, DockingStation s2) {
			
				return s1.getNumberRents()+s1.getNumberReturns() - s2.getNumberRents()-s2.getNumberReturns();
			
			}
}
