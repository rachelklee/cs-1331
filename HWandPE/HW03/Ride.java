package HW03;
/**
 * Represents a class Ride.
 * @author Rachel Lee
 * @version 1.0
 */

public abstract class Ride {
    protected final String id;
    protected double earnings = 0.0;
    protected int runsSinceInspection;
    protected String[] passengers;

    /** A constructor that creates an object Ride with 3 parameters.
     * @param i String representing id
     * @param rSI integer representing runs since inspection
     * @param passengers array of Strings representing the passengers
     */
    public Ride(String i, int rSI, String[] passengers) {
        id = i;
        runsSinceInspection = rSI;
        this.passengers = new String[passengers.length];
        for (int x = 0; x < passengers.length; ++x) {
            this.passengers[x] = passengers[x];
        }
    }

    /** A constructor that creates an object Ride with 2 parameters.
     * @param i String representing id
     * @param passengers array of Strings representing passengers
     */
    public Ride(String i, String[] passengers) {
        this(i, 0, passengers);
    }

    /** Abstract method testing if the ride can run.
     * @param runNum integer representing number of runs
     * @return boolean value representing whether or not the ride can complete a given number of runs without inspection
     */
    public abstract boolean canRun(int runNum);

    /** Abstract method to inspect the ride.
     * @param components array of Strings representing components of the ride.
     * @return boolean value representing whether or not a ride passes inspection
     */
    public abstract boolean inspectRide(String[] components);

    /** Abstract method calculating cost per passenger.
     * @param stops integer representing number of stops
     * @return double representing how much it costs for a passenger to ride a given number of stops
     */
    public abstract double costPerPassenger(int stops);

    /** Abstract method to add passengers.
     * @param stops integer representing number of stops
     * @param passengerNames array of Strings containing passengers to add
     * @return boolean representing whether or not all passengers can fit on the ride and
     * the ride can travel the given number of stops without inspection
     */
    public abstract boolean addPassengers(int stops, String[] passengerNames);

    /** Method to get all passengers.
     * @return String representing all passengers on a ride
     */
    public String getPassengerList() {
        String list = String.format("Passenger List for %s:", id);
        for (String p : passengers) {
            if (p != null) {
                list += String.format("\n%s", p.trim());
            }
        }
        return list;
    }

    /** Method to charge passengers.
     * @param stops integer representing the number of stops travelled
     */
    public final void chargePassenger(int stops) {
        //System.out.println("before earnings: " + earnings);
        earnings += costPerPassenger(stops);
        //System.out.println("after earnings: " + earnings);
    }

    /** Method to remove a passenger.
     * @param toRemove String representing the name of a passenger to remove
     * @return boolean representing whether or not a given passenger is removed
     */
    public boolean removePassenger(String toRemove) {
        for (int i = 0; i < passengers.length; ++i) {
            if (passengers[i] == null) {
                continue;
            }
            if (passengers[i].equalsIgnoreCase(toRemove)) {
                passengers[i] = null;
                return true;
            }
        }
        return false;
    }

    /** Method to test if two objects are equal to one another, overridden from Object class.
     * @param obj represents the object to compare
     * @return boolean representing whether or not two instances of ride are identical
     */
    @Override
    public boolean equals(Object obj) {
        System.out.println("testRide");
        if (obj != null && (obj instanceof Ride)) {
            Ride ride = (Ride) obj;
            return (this.id.equalsIgnoreCase(ride.id) && this.runsSinceInspection == ride.runsSinceInspection);
        }
        return false;
    }

    /** Method to return a string in a given format, overridden from Object class.
     * @return a string in a format describing an instance of Ride
     */
    @Override
    public String toString() {
        String out = String.format("%s has run %d times and has earned $%.2f", id, runsSinceInspection, earnings);
        return out;
    }
}
