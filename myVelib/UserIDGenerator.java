package project;
import java.io.Serializable;

public class UserIDGenerator implements Serializable{
	private static UserIDGenerator instance = null;
	private int num;
	// private constructor: returns the unique SerialNumberGenerator object
	private UserIDGenerator(){}
	// public getInstance method
	public static  synchronized UserIDGenerator getInstance() {
	if (instance==null) {
	instance = new UserIDGenerator();
	}
	return instance;
	}
	// public method to obtain next unique serialNumber
	public int getUserID(){
	return num++;
	}
	protected Object readResolve() {
        return getInstance();
    }
}
