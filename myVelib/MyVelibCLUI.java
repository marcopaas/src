package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class MyVelibCLUI {
    private static final String COMMAND_SETUP = "setup";
    private static final String COMMAND_ADD_USER = "addUser";
    private static final String COMMAND_CHANGE_USER_LOCATION = "changeUserLocation";
    private static final String COMMAND_CHANGE_BIKE_LOCATION = "changeBikeLocation";
    private static final String COMMAND_OFFLINE = "offline";
    private static final String COMMAND_ONLINE = "online";
    private static final String COMMAND_RENT_BIKE = "rentBike";
    private static final String COMMAND_RETURN_BIKE = "returnBike";
    private static final String COMMAND_DISPLAY_STATION = "displayStation";
    private static final String COMMAND_DISPLAY_USER = "displayUser";
    private static final String COMMAND_SORT_STATION = "sortStation";
    private static final String COMMAND_DISPLAY = "display";
    private static final String COMMAND_HELP = "help";
    private static final String COMMAND_RUN_TEST = "runtest";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //MyVelibSystem myVelibSystem = new MyVelibSystem();
        //System.out.print(System.getProperty("user.dir"));
        while (true) {
            System.out.print("Enter command: ");
            String command = null;
            String[] commandParts = null;
            try {
            	command = scanner.nextLine();
            	commandParts = command.split(" ");
            }
            catch (NoSuchElementException e) {
				System.out.println("scenario terminato");
				scanner = new Scanner(System.in);
				continue;
			}
            
            //setup function
            if (commandParts[0].equals(COMMAND_SETUP)) {
                if (commandParts.length == 6) {
                	String velibNetworkName = commandParts[1];
                	try {
                    int numStations = Integer.parseInt(commandParts[2]);
                    int numParkingBays = Integer.parseInt(commandParts[3]);
                    int dimension = Integer.parseInt(commandParts[4]);
                    int numBikes = Integer.parseInt(commandParts[5]);
                    if(numBikes>numStations*numParkingBays) {
                    	System.out.println("number of bike greater than number of slots. try again");
                    	continue;
                    }
                    MyVelib.setup(velibNetworkName, numStations, numParkingBays, dimension, numBikes);
                    System.out.println("myVelib system set up successfully.");
                	}
                	catch(NumberFormatException e){System.out.println("you insert the arguments in a bad format"); continue;}
                }
                else if (commandParts.length == 2) {
                	String velibNetworkName = commandParts[1];
                	try {
                	int numStations = 10;
                    int numParkingBays = 10;
                    int dimension = 4000; //4 km
                    double d = numStations*numParkingBays*0.75;
                    int numBikes = (int)d;

                    MyVelib.setup(velibNetworkName, numStations, numParkingBays, dimension, numBikes);
                    System.out.println("myVelib system set up successfully.");
                	}
                	catch(NumberFormatException e){System.out.println("you insert the arguments in a bad format"); continue;}

                }
                else {
                	System.out.println("Invalid number of arguments. Usage: setup <velibnetworkName> <numStations> <numParkingBays> <numBikes>");
                    continue;
                }
            } 
            
            //add user
            else if (commandParts[0].equals(COMMAND_ADD_USER)) {
                if (commandParts.length != 4) {
                    System.out.println("Invalid number of arguments. Usage: addUser <userName cardType velibnetworkName>");
                    continue;
                }
                
                String velibNetworkName = commandParts[3];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
                String username = commandParts[1];
                String card = commandParts[2];
                String VelibNetworkName = commandParts[3];
                User user;
                Location loc;
                try {
	                System.out.println("insert user location : e.g. 4.5 2.22");
	                String sc = scanner.nextLine();
	                String[] scp = sc.split(" ");
	                int x = Integer.parseInt(scp[0]);
	                int y = Integer.parseInt(scp[1]);
	                loc = new Location("",x,y);
                }catch (NumberFormatException e) {
                    System.out.println("you insert invalid format, user location set to : 0 0 ");
                    loc = new Location("",0,0);
                }
                if (card.equals("none")) user = new User(username, loc);
                else if (card.equals("Vlib")) user = new UserWithRegistrationCard(username, loc, new VlibreCard(username));
                else if (card.equals("Vmax")) user = new UserWithRegistrationCard(username, loc, new VmaxCard(username));
                else continue;
                MyVelib.addUser(user);
                System.out.println("User added successfully.");
            }
          //change user position
            else if (commandParts[0].equals(COMMAND_CHANGE_USER_LOCATION)) {
                if (commandParts.length != 2) {
                    System.out.println("Invalid number of arguments. Usage: changeUserLocation <userID>");
                    continue;
                }

                int id = Integer.parseInt(commandParts[1]);
                User user = null;
                for(User us : MyVelib.getUsers())if(us.getId()==id)user=us;
                Location loc;
                try {
	                System.out.println("insert user location : e.g. 4.5 2.22");
	                String sc = scanner.nextLine();
	                String[] scp = sc.split(" ");
	                int x = Integer.parseInt(scp[0]);
	                int y = Integer.parseInt(scp[1]);
	                loc = new Location("",x,y);
                }catch (NumberFormatException e) {
                    System.out.println("you insert invalid format, user location set to : 0 0 ");
                    loc = new Location("",0,0);
                }
                user.setGps(loc);
                System.out.println("Position Changed succesfully");
            }
          //change user position
            else if (commandParts[0].equals(COMMAND_CHANGE_BIKE_LOCATION)) {
                if (commandParts.length != 2) {
                    System.out.println("Invalid number of arguments. Usage: changeUser <userID>");
                    continue;
                }

                int id = Integer.parseInt(commandParts[1]);
                Bike bike = null;
                for(Bike b : MyVelib.getBikes())if(b.getId()==id)bike=b;
                Location loc;
                try {
	                System.out.println("insert bike location : e.g. 4.5 2.22");
	                String sc = scanner.nextLine();
	                String[] scp = sc.split(" ");
	                int x = Integer.parseInt(scp[0]);
	                int y = Integer.parseInt(scp[1]);
	                loc = new Location("",x,y);
                }catch (NumberFormatException e) {
                    System.out.println("you insert invalid format, user location set to : 0 0 ");
                    loc = new Location("",0,0);
                }
                bike.setGps(loc);
                System.out.println("Position Changed succesfully");
            }
            
            //set station offline
            else if (commandParts[0].equals(COMMAND_OFFLINE)) {
                if (commandParts.length != 3) {
                    System.out.println("Invalid number of arguments. Usage: offline <stationID>");
                    continue;
                }
                String velibNetworkName = commandParts[1];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
                boolean flag = true;
                int ID = Integer.parseInt(commandParts[2]);
                for(DockingStation ds : MyVelib.getStations()) {
                	if(ds.getId()==ID) {
                		ds.setOnService(false);
                		System.out.println("Station set offline successfully.");
                		flag = false;
                	}
                }
                if(flag)System.out.println("Station not found");
            } 
            
            else if (commandParts[0].equals(COMMAND_ONLINE)) {
            	if (commandParts.length != 3) {
                    System.out.println("Invalid number of arguments. Usage: offline <stationID>");
                    continue;
                }
            	String velibNetworkName = commandParts[1];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
                boolean flag = true;
                int ID = Integer.parseInt(commandParts[2]);
                for(DockingStation ds : MyVelib.getStations()) {
                	if(ds.getId()==ID) {
                		ds.setOnService(true);
                		System.out.println("Station set online successfully.");
                		flag = false;
                	}
                }
                if(flag)System.out.println("Station not found");
            } 
            
            else if (commandParts[0].equals(COMMAND_RENT_BIKE)) {
                if (commandParts.length != 3) {
                    System.out.println("Invalid number of arguments. Usage: rentBike <username> <stationID>");
                    continue;
                }
                boolean flag = true;
                int userID = Integer.parseInt(commandParts[1]);
                int stationID = Integer.parseInt(commandParts[2]);
                for(User us : MyVelib.getUsers()) {
                	if(us.getId()==userID) {
                		us.simpleRent(stationID);
                		flag = false;
                	}
                }
                if(flag)System.out.println("User not found");
            } 
            
            else if (commandParts[0].equals(COMMAND_RETURN_BIKE)) {
                if (commandParts.length != 4) {
                    System.out.println("Invalid number of arguments. Usage: returnBike <username> <stationID> <duration>");
                    continue;
                }

                boolean flag = true;
                int userID = Integer.parseInt(commandParts[1]);
                int stationID = Integer.parseInt(commandParts[2]);
                int duration = Integer.parseInt(commandParts[3]);
                User userfound = null;
                for(User us : MyVelib.getUsers()) {
                	if(us.getId()==userID) {
                		userfound = us;
                		flag = false;
                	}
                }
                if(flag) {
                	System.out.println("User not found");
                	continue;
                }
                if(!userfound.getHasBike()) {
                	System.out.println("User has no bike");
                	continue;
                }
                flag =true;
                //find the station
                ArrayList<DockingStation> stations = MyVelib.getStations();
                DockingStation exactStation = null;
				for(DockingStation s : stations){
					if(s.getId()==stationID) {
						exactStation = s;
						flag = false;
					}
				}
				if(flag) {
                	System.out.println("Station not found");
                	continue;
                }
				if(!exactStation.isOnService()) {
                	System.out.println("Station is not in service try again");
                	continue;
                }
				if(userfound.getBike().getGps()!=exactStation.getGps()) {
					System.out.println("the bike is not in the same spot as the station. Not possible to return the bike");
                	continue;
				}
                BikeRide ride = userfound.getCurrentRide();
        		//ride.setEnd(userfound.getGps()); //probabilmente da cambiare con il gps della bike
                ride.setEnd(exactStation.getGps());
                //userfound.setGps(null);
        		userfound.getCurrentRide().setTimeCharged(duration);
        		userfound.simpleReturnBike();
            } 
            
            else if (commandParts[0].equals(COMMAND_DISPLAY_STATION)) {
                if (commandParts.length != 3) {
                    System.out.println("Invalid number of arguments. Usage: displayStation <stationID>");
                    continue;
                }
                String velibNetworkName = commandParts[1];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
                boolean flag = true;
                int ID = Integer.parseInt(commandParts[2]);
                for(DockingStation ds : MyVelib.getStations()) {
                	if(ds.getId()==ID) {
                		System.out.println(ds.toString());
                		flag = false;
                	}
                }
                if(flag)System.out.println("Station not found");
            }
            
            else if (commandParts[0].equals(COMMAND_DISPLAY_USER)) {
                if (commandParts.length != 3) {
                    System.out.println("Invalid number of arguments. Usage: displayUser<velibnetworkName, userID>");
                    continue;
                }
                String velibNetworkName = commandParts[1];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
                boolean flag = true;
                int ID = Integer.parseInt(commandParts[2]);
                for(User us : MyVelib.getUsers()) {
                	if(us.getId()==ID) {
                		System.out.println(us.toString());
                		flag = false;
                	}
                }
                if(flag)System.out.println("Station not found");
            } 
            
//            else if (commandParts[0].equals(COMMAND_SORT_STATION)) {
//                if (commandParts.length != 1) {
//                    System.out.println("Invalid number of arguments. Usage: sortStation");
//                    continue;
//                }
//
//                MyVelib.sortStation();
//            } 
            
            else if (commandParts[0].equals(COMMAND_DISPLAY)) {
                if (commandParts.length != 2) {
                    System.out.println("Invalid number of arguments. Usage: display <velibnetworkName>");
                    continue;
                }
                String velibNetworkName = commandParts[1];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
                System.out.println("-----------U S E R S------------");
                for(User us : MyVelib.getUsers()) {
                	System.out.println(us.toString());
                }
                System.out.println("--------S T A T I O N S---------");

                for(DockingStation st : MyVelib.getStations()) {
                	System.out.println(st.toString());
                }
                System.out.println("-----------B I K E S------------");

                for(Bike b : MyVelib.getBikes()) {
                	System.out.println(b.toString());
                }
            
            } 
            else if (commandParts[0].equals(COMMAND_RUN_TEST)) {
                if (commandParts.length != 2) {
                    System.out.println("Invalid number of arguments. Usage: tets");
                    continue;
                }
                String filename = commandParts[1];
                File file = new File(filename);
                try {
					scanner = new Scanner(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
            }
            else if (commandParts[0].equals(COMMAND_SORT_STATION)) {
            	if (commandParts.length != 3) {
                  System.out.println("Invalid number of arguments. Usage: sortStation");
                  continue;
              }
            	String velibNetworkName = commandParts[1];
            	if(!velibNetworkName.equals(MyVelib.getName())) {
            		System.out.println("wrong network name");
            		continue;
            	}
              if(commandParts[2].equals("leastOccupied")) {
              	ArrayList<DockingStation> stations = new ArrayList<DockingStation>();
              	stations =  MyVelib.sort("leastOccupied");
              	for(DockingStation s : stations) {
              		System.out.println(s.toString());
              	}
              	
              }
              else if(commandParts[2].equals("mostUsed")){
              	ArrayList<DockingStation> stations = new ArrayList<DockingStation>();
              	stations =  MyVelib.sort("mostUsed");
              	for(DockingStation s : stations) {
              		System.out.println(s.toString());
              	}
              }
              else {
              	System.out.println("Invalid sorting policy: it can either be leastOccupied or mostUsed");
              	continue;
             }
            }
//                
            
            else if (commandParts[0].equals(COMMAND_HELP)) {
                if (commandParts.length != 1) {
                    System.out.println("Invalid number of arguments. Usage: display");
                    continue;
                }
                System.out.println("The commands supported are: setup <velibnetworkName>");
                System.out.println("setup <velibnetworkName>");
                System.out.println("setup <name> <nstations> <nslots> <s> <nbikes>");
                System.out.println("addUser <userName,cardType, velibnetworkName>");
                System.out.println("changeUserLocation <userID>");
                System.out.println("changeBikeLocation <userID>");
                System.out.println("offline <velibnetworkName, stationID>");
                System.out.println("online <velibnetworkName, stationID>");
                System.out.println("rentBike <userID, stationID>");
                System.out.println("rentBike <userID, GPS_Position>");
                System.out.println("returnBike <userID, stationID, duration>");
                System.out.println("returnBike <userID, GPS_Position, duration>");
                System.out.println("displayStation<velibnetworkName, stationID>");
                System.out.println("displayUser<velibnetworkName, userID>");
                System.out.println("sortStation<velibnetworkName, sortpolicy> ");
                System.out.println("display <velibnetworkName>");
                System.out.println("runtest <testScenario1.txt>");
                
                
            }
            
            else {
                System.out.println("Unknown command. Type 'help' for suggestions");
            }
        }
    }
}