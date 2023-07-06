package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserIDGeneratorTest {

	@Test
	void testGetInstance() {
		UserIDGenerator instance1 = UserIDGenerator.getInstance();
		UserIDGenerator instance2 = UserIDGenerator.getInstance();

        // Both instances should be the same
		assertTrue(instance1 == instance2);
	}

	@Test
	void testGetUserID() {
		UserIDGenerator instance = UserIDGenerator.getInstance();
		assertTrue(instance.getUserID()==instance.getUserID()-1);
	}

}
