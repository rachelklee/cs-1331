package HW04;
/**
 * Represents a class Ghost that extends the abstract class TrickOrTreater.
 * @author Rachel Lee
 * @version 1.0
 */
public class Ghost extends TrickOrTreater {
    private int robberiesConducted;

    /** A constructor that creates an object Ghost with 3 parameters.
     * @param name String representing the Ghost's name
     * @param age integer representing the Ghost's age
     * @param numCandy integer representing the amount of candy the Ghost has
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    /** A constructor that creates an object Ghost with no parameters.
     */
    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    /**
     * A method that implements the abstract method in the parent class TrickOrTreater.
     */
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        gainCandy(2);
    }

    /**
     * A method that robs a trick or treater.
     * @param t Tricker or treater being robbed
     */
    public void rob(TrickOrTreater t) {
        if (t instanceof Robbable) {
            Robbable r = (Robbable) t;
            int robbed = r.beRobbed();
            if (robbed > 0) {
                this.gainCandy(robbed);
                ++this.robberiesConducted;
            }
        }
    }

    /** Method to return a string in a given format, overridden from TrickOrTreater class.
     * @return a string in a format describing an instance of Ghost
     */
    @Override
    public String toString() {
        return String.format("%s/%d", super.toString(), robberiesConducted);
    }

    /** Method that compares two Ghost objects, overridden from TrickOrTreater class.
     * @return an integer that compares two Ghost objects
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        int comp = super.compareTo(other);
        if (comp == 0 && this.getClass() == other.getClass()) {
            return this.robberiesConducted - ((Ghost) other).robberiesConducted;
        }
        return comp;
    }
}
