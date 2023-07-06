package project;

public class VlibElecStrategy implements CostStrategy {

    public double computeCost(double minutes){
    	if(minutes<=60)return minutes/60;
        return 1 + (minutes-60)*2/60;
    }
}