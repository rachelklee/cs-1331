package HW03;
/**
 * Represents a class RollerCoaster, the child of the class Ride.
 * @author Rachel Lee
 * @version 1.0
 */

public class RollerCoaster extends Ride {
    private double rate;
    private double photoFees;
    private int maxNumRuns;
    private int emptySeats;

    /** A constructor that creates an object RollerCoaster with 6 parameters.
     * @param i String representing id
     * @param rSI integer representing runs since inspection
     * @param passengers array of Strings representing the passengers
     * @param r double representing the rate
     * @param pF double representing the photo fees
     * @param mNR representing the maximum number of runs
     */
    public RollerCoaster(String i, int rSI, String[] passengers, double r, double pF, int mNR) {
        super(i, rSI, passengers);
        rate = r;
        photoFees = pF;
        maxNumRuns = mNR;
    }

    /** A constructor that creaes an object RollerCoaster with 3 parameters.
     * @param i String representing id
     * @param rSI integer representing runs since inspection
     * @param mNR representing the maximum number of runs
     */
    public RollerCoaster(String i, int rSI, int mNR) {
        this(i, rSI, new String[4], 10, 15, mNR);
    }

    /** A constructor that creaes an object RollerCoaster with 1 parameter.
     * @param i String representing id
     */
    public RollerCoaster(String i) {
        this(i, 0, new String[4], 10, 15, 200);
    }

    /** Method testing if the ride can run. Implements abstract class from parent class Ride.
     * @param runNum integer representing number of runs
     * @return boolean value representing whether or not the ride can complete a given number of runs without inspection
     */
    @Override
    public boolean canRun(int runNum) {
        return (runNum >= 0 && runNum + runsSinceInspection <= maxNumRuns);
    }

    /** Method to inspect the ride. Implements abstract class from parent class Ride.
     * @param components array of Strings representing components of the ride.
     * @return boolean value representing whether or not a ride passes inspection
     */
    @Override
    public boolean inspectRide(String[] components) {
        boolean tracksClear = false;
        boolean brakeOk = false;

        for (int i = 0; i < components.length; ++i) {
            if (components[i].equalsIgnoreCase("Tracks Clear")) {
                tracksClear = true;
            }
            if (components[i].equalsIgnoreCase("Brakes Ok")) {
                brakeOk = true;
            }
        }

        if (tracksClear && brakeOk) {
            runsSinceInspection = 0;
            return true;
        } else {
            return false;
        }
    }

    /** Method calculating cost per passenger. Implements abstract class from parent class Ride.
     * @param stops integer representing number of stops
     * @return double representing how much it costs for a passenger to ride a given number of stops
     */
    @Override
    public double costPerPassenger(int stops) {
        double cost = photoFees + (rate * stops);
        return cost;
    }

    /** Helper method that counts empty seats on a roller coaster
     * @return integer representing the number of empty seats
     */
    private int countEmptySeats() {
        emptySeats = 0;
        for (int i = 0; i < passengers.length; ++i) {
            if (passengers[i] == null) {
                emptySeats++;
            }
        }
        //System.out.println("EMPTY SEATS: " + emptySeats);
        return emptySeats;
    }

    /** Method to add passengers. Implements abstract class from parent class Ride.
     * @param stops integer representing number of stops
     * @param passengerNames array of Strings containing passengers to add
     * @return boolean representing whether or not all passengers can fit on the ride and
     * the ride can travel the given number of stops without inspection
     */
    @Override
    public boolean addPassengers(int stops, String[] passengerNames) {
        if (stops <= maxNumRuns && countEmptySeats() >= passengerNames.length && canRun(stops)) {
            System.out.println("number of pass to add: " + passengerNames.length);
            int passNum = 0;
            for (int i = 0; i < passengers.length; ++i) {
                //System.out.println("length of passengers: " + passengers.length);
                //System.out.println("Length of passenger names: " + passengerNames.length);
                if (passengers[i] == null && i < passengerNames.length) {
                    //System.out.println("index of passengers (): " + i);
                    //System.out.println("index of passenger names (adding this passenger): " + passNum);
                    passengers[i] = passengerNames[passNum];
                    ++passNum;
                }
            }

            earnings += passengerNames.length * costPerPassenger(stops);
            runsSinceInspection += stops;

            return true;
        } else {
            return false;
        }
    }

    /** Method to test if two objects are equal to one another, overridden from Ride class.
     * @param obj represents the object to compare
     * @return boolean representing whether or not two instances of RollerCoaster are identical
     */
    @Override
    public boolean equals(Object obj) {
        System.out.println("testRollerCoaster");
        if (obj != null && (obj instanceof RollerCoaster)) {
            RollerCoaster r = (RollerCoaster) obj;
            return (this.id.equalsIgnoreCase(r.id) && this.runsSinceInspection == r.runsSinceInspection
                && this.rate == r.rate && this.photoFees == r.photoFees && this.maxNumRuns == r.maxNumRuns);
        }
        return false;
    }

    /** Method to return a string in a given format, overridden from Ride class.
     * @return a string in a format describing an instance of RollerCoaster
     */
    @Override
    public String toString() {
        String out = String.format(
            "Roller Coaster %s. It can only run %d more times."
            + "It costs $%.2f per ride and there is a one-time photo fee of $%.2f.",
            super.toString(), maxNumRuns - runsSinceInspection, rate, photoFees);
        return out;
    }
}
