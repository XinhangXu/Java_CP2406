import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        //Input city information
        Scanner mySim = new Scanner(System.in);

        // set values for user inputs for prototype.
		int roadSpawns = 2; int carSpawns = 1; int lightSpawns = 1;

//        System.out.print("How many roads? :");
//        int roadSpawns = mySim.nextInt();
//        
//        System.out.print("How many cars? :");
//        int carSpawns = mySim.nextInt();
//        
//        System.out.print("How many traffic lights? :");
//        int lightSpawns = mySim.nextInt();
        
		System.out.println("There are 2 roads, 1 car and 1 traffic light.\n");
        
        

        //set info of roads
        System.out.println("Setting:\n");
        
        System.out.println("_______________Roads_______________");
        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < roadSpawns; i++) {
            System.out.print("Road No." + i + " --> Length:");
            int lengthInput = mySim.nextInt();
            System.out.print("Road No." + i + " --> Speed limit(per second):");
            int speedLimitInput = mySim.nextInt();
            roads.add(new Road(Integer.toString(i), speedLimitInput, lengthInput, new int[]{0, 0}));
        }

        
        System.out.println("\n_____________Details_______________\n");
        
        //print default car details
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carSpawns; i++) {
            cars.add(new Car(Integer.toString(i), roads.get(0))); // all created cars will begin on road_0.
            cars.get(i).printCarStatus();
        }
        
        //print default light details
        ArrayList<TrafficLight> lights = new ArrayList<>();
        for (int i = 0; i < lightSpawns; i++) {
            lights.add(new TrafficLight(Integer.toString(i), roads.get(0))); // all created lights will begin on road_0.
            lights.get(i).printLightStatus();
        }
        System.out.println();


        // set locations and connections:
        roads.get(1).setStartLocation(new int[]{roads.get(0).getLength() + 1, 0}); // place road_1 to a position at the end of road_0.
        //print details of road_0 and road_1
        roads.get(0).printRoadInfo();
        roads.get(1).printRoadInfo();
        roads.get(0).getConnectedRoads().add(roads.get(1)); // connect road_0 to road_1, the length of whole road is r0+r1
        System.out.println();


        //Simulation loop:
        System.out.println("\n_____________Simulation____Start________________\n");
        Random random = new Random();
        int time = 0;
        //System.out.print("Set time scale in milliseconds:");
        int speedOfSim = 1000; // sleep every 1 second //int speedOfSim = mySim.nextInt();
        int carsFinished = 0;
        
        
        //while (carsFinished < cars.size()) {
        //simulate road_0
        int simTimes_r0 = roads.get(0).getLength() / roads.get(0).getSpeedLimit();
        for(int i = 0;i < simTimes_r0;i++) {
        	//System.out.println(" simTimes:" + simTimes +"\n");
            for (TrafficLight light : lights) {
                light.operate(random.nextInt());
                light.printLightStatus();
            }
            for (Car car : cars) {
                car.move();
                car.printCarStatus();
                if (car.getCurrentRoad().getConnectedRoads().isEmpty() && (car.getSpeed() == 0)) {
                    carsFinished = carsFinished + 1;
                }
            }
            time = time + 1;
            System.out.println(time + " Seconds have passed.\n");
            try {
                Thread.sleep(speedOfSim); // set break time
            } catch (InterruptedException sim) {
                Thread.currentThread().interrupt();
            }
        //}
        }
        
        System.out.println("|Go\n|To\n|Next\n|Road\n");
        
        
        //simulate road_1
        int simTimes_r1 = roads.get(1).getLength() / roads.get(1).getSpeedLimit();
        int simPosition = 1;
        for(int i = 0;i < simTimes_r1;i++) {
       
            for (TrafficLight light : lights) {
                light.operate(random.nextInt());
                light.printLightStatus();
            }
            for (Car car : cars) {
            	car.setCurrentRoad(roads.get(1));
            	car.setPosition(simPosition);
            	simPosition = simPosition + car.getSpeed();
                car.move();
                car.printCarStatus();
                if (car.getCurrentRoad().getConnectedRoads().isEmpty() && (car.getSpeed() == 0)) {
                    carsFinished = carsFinished + 1;
                }
            }
            time = time + 1;
            System.out.println(time + " Seconds have passed.\n");
            try {
                Thread.sleep(speedOfSim); // set break time
            } catch (InterruptedException sim) {
                Thread.currentThread().interrupt();
            }
        }
        
        
        System.out.println("\n_____________Simulation____Finished________________\n");


    }
}
