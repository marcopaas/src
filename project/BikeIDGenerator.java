package project;

import java.io.Serializable;

public class BikeIDGenerator implements Serializable{
	private static BikeIDGenerator instance = null;
	private int num;
	// private constructor: returns the unique SerialNumberGenerator object
	private BikeIDGenerator(){}
	// public thread−safe getInstance method
	public static synchronized BikeIDGenerator getInstance() {
		if (instance==null) {
		instance = new BikeIDGenerator();
	}
	return instance;
	}
	
	// public method to obtain next unique serialNumber
	public int getBikeID(){
	return num++;
	}
	protected Object readResolve() {
        return getInstance();
    }
}
