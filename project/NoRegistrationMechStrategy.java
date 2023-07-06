package project;

public class NoRegistrationMechStrategy implements CostStrategy {

    public double computeCost(double minutes){
        return minutes*1/60;
    }
}