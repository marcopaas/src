package project;
import java.io.Serializable;


public class StationIDGenerator implements Serializable{
	private static StationIDGenerator instance = null;
	private int num;
	// private constructor: returns the unique SerialNumberGenerator object
	private StationIDGenerator(){}
	// public getInstance method
	public static synchronized StationIDGenerator getInstance() {
	if (instance==null) {
	instance = new StationIDGenerator();
	}
	return instance;
	}
	// public method to obtain next unique serialNumber
	public int getStationID(){
	return num++;
	}
	protected Object readResolve() {
        return getInstance();
    }
}
