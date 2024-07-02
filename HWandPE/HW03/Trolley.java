package HW03;
/**
 * Represents a class Trolley, the child of the class Ride.
 * @author Rachel Lee
 * @version 1.0
 */

public class Trolley extends Ride {
    private String[] stations;
    private int currentStation;

    /** A constructor that creates an object RollerCoaster with 4 parameters.
     * @param i String representing id
     * @param rSI integer representing runs since inspection
     * @param stations array of Strings representing the stations
     * @param cS integer representing the current station
     */
    public Trolley(String i, int rSI, String[] stations, int cS) {
        super(i, rSI, new String[20]);
        //System.out.println("4 arg const. cs: " + cS);
        currentStation = cS;
        if (stations != null) {
            this.stations = new String[stations.length];
            for (int idx = 0; idx < stations.length; ++idx) {
                this.stations[idx] = stations[idx];

                //System.out.println("this station at " + i + ": " + this.stations[idx]);
                //System.out.println("stations at " + i + ": " + stations[idx]);
            }
        } else {
            this.stations = new String[0];
        }

        /**System.out.print("this.stations: ");
        for (String s : this.stations) {
            System.out.print(s + ", ");
        }
        System.out.println("");
        System.out.print("stations: ");
        for (String s : stations) {
            System.out.print(s + ", ");
        }
        System.out.println("");**/
    }

    /** A constructor that creates an object RollerCoaster with 3 parameters.
     * @param i String representing id
     * @param stations array of Strings representing the stations
     * @param cS integer representing the current station
     */
    public Trolley(String i, String[] stations, int cS) {
        this(i, 0, stations, cS);
        //System.out.println("3 arg const. cs: " + cS);

    }

    /** Method testing if the ride can run. Implements abstract class from parent class Ride.
     * @param runNum integer representing number of runs
     * @return boolean value representing whether or not the ride can complete a given number of runs without inspection
     */
    @Override
    public boolean canRun(int runNum) {
        return runNum >= 0;
    }

    /** Method to inspect the ride. Implements abstract class from parent class Ride.
     * @param components array of Strings representing components of the ride.
     * @return boolean value representing whether or not a ride passes inspection
     */
    @Override
    public boolean inspectRide(String[] components) {
        boolean gasTank = false, brakes = false;
        for (String c : components) {
            if (c.equalsIgnoreCase("Gas Tank Not Empty")) {
                gasTank = true;
            }
            if (c.equalsIgnoreCase("Brakes Ok")) {
                brakes = true;
            }
            if (gasTank && brakes) {
                runsSinceInspection = 0;
                break;
            }
        }

        return gasTank && brakes;
    }

    /** Method calculating cost per passenger. Implements abstract class from parent class Ride.
     * @param stops integer representing number of stops
     * @return double representing how much it costs for a passenger to ride a given number of stops
     */
    @Override
    public double costPerPassenger(int stops) {
        //System.out.println("cost per passenger: " + (double) (stops * 3) / stations.length);
        return (double) (stops * 3) / stations.length;
    }

    /** Method to add passengers. Implements abstract class from parent class Ride.
     * @param stops integer representing number of stops
     * @param passengerNames array of Strings containing passengers to add
     * @return boolean representing whether or not all passengers can fit on the ride and
     * the ride can travel the given number of stops without inspection
     */
    @Override
    public boolean addPassengers(int stops, String[] passengerNames) {
        if (stops < 0) {
            return false;
        }
        if (canRun((currentStation + stops) / stations.length)) {
            for (int j = 0, i = 0; j < passengers.length; ++j) {
                if (passengers[j] == null && j < passengerNames.length) {
                    passengers[j] = passengerNames[i];
                    ++i;
                    chargePassenger(stops);
                }
            }
            moveTrolley(stops);
            return true;
        }
        return false;
    }

    /** Method to move the trolley.
     * @param stops integer representing the number of stops to move
     */
    public void moveTrolley(int stops) {
        if (stops <= 0) {
            return;
        }

        runsSinceInspection += (currentStation + stops) / stations.length;
        currentStation = (currentStation + stops) % stations.length;
        //System.out.println("=====" + currentStation);
    }

    /** Method to test if two objects are equal to one another, overridden from Ride class.
     * @param obj represents the object to compare
     * @return boolean representing whether or not two instances of RollerCoaster are identical
     */
    @Override
    public boolean equals(Object obj) {
        System.out.println("testTrolley");
        if (obj != null && obj instanceof Trolley) {
            Trolley trolley = (Trolley) obj;
            boolean equalId = this.id.equalsIgnoreCase(trolley.id);
            boolean equalRSI = this.runsSinceInspection == trolley.runsSinceInspection;
            boolean equalCS = this.currentStation == trolley.currentStation;
            //System.out.println("this current station: "+ this.currentStation);
            //System.out.println("trolley current station: " + trolley.currentStation);
            boolean equalStations = true;
            if (this.stations.length == trolley.stations.length) {
                for (int i = 0; i < this.stations.length; ++i) {
                    if (!(this.stations[i].equalsIgnoreCase(trolley.stations[i]))) {
                        equalStations = false;
                        break;
                    }
                }
            } else {
                equalStations = false;
            }
            return equalId && equalRSI && equalCS && equalStations;
        }
        return false;
    }

    /** Method to return a string in a given format, overridden from Ride class.
     * @return a string in a format describing an instance of RollerCoaster
     */
    @Override
    public String toString() {
        // System.out.println("RSI: " + runsSinceInspection);
        // System.out.println("LOOPS: " + loops);
        String out = String.format("Trolley %s has driven %d loops and has earned $%.2f."
            + "This trolley is at %s. Next up is %s.", id, runsSinceInspection, earnings,
            stations[currentStation], stations[(currentStation + 1) % stations.length]);
        return out;
    }
}