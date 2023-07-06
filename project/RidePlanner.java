package project;

public class RidePlanner{
    private RidePlanning planning;
    public RidePlanner(RidePlanning planning){
        this.planning = planning;
    }
    public Bike getStart(Location userloc, BikeType type){
        return planning.getBikeStart(userloc, type);
    }
    public Location getEnd(Location loc){
    	DockingStation temp = planning.getStationEnd(loc);
    	//System.out.println(temp);
        return temp.getGps();
    }
    public void setPlanning(RidePlanning planning){
        this.planning =  planning;
    }
}