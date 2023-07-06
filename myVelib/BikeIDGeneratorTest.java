package project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Test;

class BikeIDGeneratorTest {

	@Test
	void testGetInstance() {
		BikeIDGenerator instance1 = BikeIDGenerator.getInstance();
		BikeIDGenerator instance2 = BikeIDGenerator.getInstance();

        // Both instances should be the same
		assertTrue(instance1 == instance2);
	}

	@Test
	void testGetBikeID() {
		BikeIDGenerator instance = BikeIDGenerator.getInstance();
		assertTrue(instance.getBikeID()==instance.getBikeID()-1);
	}

}
