package HW02;
/**
 * Represents a child class of Fish called StripedBass.
 * @author Rachel Lee
 * @version 1.0
 */

public class StripedBass extends Fish {
    private int stripeCount;
    private boolean isSaltwater;
    private Catfish bestFriend;

    /**
     * A constructor that creates an object StripedBass with six parameters.
     * @param n The name of the StripedBass as a String
     * @param l The length of the StripedBass as a Double
     * @param w The weight of the  StripedBass as a Double
     * @param s The stripeCount of the StripedBass as an integer
     * @param i Whether or not the StripedBass lives in salt water as a boolean
     * @param bestFriend The Catfish bestFriend of the StripedBass
     */
    public StripedBass(String n, Double l, Double w, int s, boolean i, Catfish bestFriend) {
        super(n, l, w);

        stripeCount = s;
        isSaltwater = i;

        if (bestFriend != null) {
            this.bestFriend = new Catfish(bestFriend);

        } else {
            this.bestFriend = null;
        }

        if (s <= 0) {
            stripeCount = 25;
        }

    }

    /** A default constructor that creates an object StripedBass with no parameters.
     */
    public StripedBass() {
        this("Striper", 30.0, 320.0, 14, false, null);
    }

    /** A deep copy constructor that creates a new StripedBass based on another StripedBass instance.
     * @param s Instance of StripedBass that is being copied
    */
    public StripedBass(StripedBass s) {
        this(s.name, s.length, s.weight, s.stripeCount, s.isSaltwater, s.bestFriend);
    }

    /** Allows a StripedBass to move to the opposite type of water (freshwater or saltwater)
     *  based on whether or not it has a best friend. */
    public void migrate() {
        if (bestFriend == null) {
            if (isSaltwater) {
                isSaltwater = false;
            } else {
                isSaltwater = true;
            }
        }
    }

    /** Returns a String describing the name, length, weight, stripeCount, and bestFriend status of a StripedBass.
     * @return The StripedBass attributes formatted
    */
    @Override
    public String toString() {
        String waterStat;
        if (isSaltwater) {
            waterStat = "saltwater";
        } else {
            waterStat = "freshwater";
        }
        String bestfriendstat;
        if (bestFriend == null) {
            bestfriendstat = "no best friend";
        } else {
            bestfriendstat = "a best friend named " + bestFriend.name;
        }
        String out = String.format("%s I'm a %s striped bass with %d stripes. I have %s.", super.toString(),
            waterStat, stripeCount, bestfriendstat);
        return out;
    }
}
