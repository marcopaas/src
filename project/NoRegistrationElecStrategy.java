package project;

public class NoRegistrationElecStrategy implements CostStrategy {

    public double computeCost(double minutes){
        return minutes*2/60;
    }
}