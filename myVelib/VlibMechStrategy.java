package project;

public class VlibMechStrategy implements CostStrategy {

    public double computeCost(double minutes){
    	if(minutes>60)
    		return (minutes-60)*1/60;
    	else return 0;
    }
}