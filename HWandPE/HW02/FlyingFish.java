package HW02;
import java.util.Random;

/**
 * Represents a child class of Fish called FlyingFish.
 * @author Rachel Lee
 * @version 1.0
 */

public class FlyingFish extends Fish {
    private int flightTime;
    private Random rand = new Random();

    /**
     * A constructor that creates an object FlyingFish with four parameters.
     * @param n The name of the FlyingFish as a String
     * @param l The length of the FlyingFish as a Double
     * @param w The weight of the FlyingFish as a Double
     * @param f The flight time of the FlyingFish as an integer
     */
    public FlyingFish(String n, Double l, Double w, int f) {
        super(n, l, w);

        flightTime = f;

        if (f <= 0) {
            flightTime = 30;
        }
    }

    /** A default constructor that creates an object FlyingFish with no parameters.
     */
    public FlyingFish() {
        this("Gilbert", 12.0, 24.0, 36);
    }

    /** A deep copy constructor that creates a new StripedBass based on another FlyingFish instance.
     * @param f Instance of FlyingFish that is being copied
    */
    public FlyingFish(FlyingFish f) {
        this(f.name, f.length, f.weight, f.flightTime);
    }

    /** Calculates the power of a FlyingFish based on the weight and flightTime.
     * @return The power of the FlyingFish
    */
    public double calculatePower() {
        double power = weight * flightTime;
        return power;
    }

    /** Prints a String representing a FlyingFishes flying time. */
    public void fly() {
        int time = rand.nextInt(flightTime);
        String out = String.format("Woohoo! %s flew for %d", name, time);
        System.out.println(out);
    }

    /** Returns a String describing the name, length, weight, flightTime, and power status of a FlyingFish.
     * @return The FlyingFish attributes formatted
    */
    @Override
    public String toString() {
        String out = String.format("%s I'm a flying fish, and my flight time record is %d, so my power is %.2f.",
            super.toString(), flightTime, calculatePower());
        return out;
    }
}
