package HW04;
/**
 * Represents an abstract class Trick or Treater that implements Comparable.
 * @author Rachel Lee
 * @version 1.0
 */

public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {
    private String name;
    private int age;
    private int numCandy;

    /** A constructor that creates an object TrickOrTreater with 3 parameters.
     * @param name String representing the Trick or treater's name
     * @param age integer representing the Trick or treater's age
     * @param numCandy integer representing the amount of candy the Trick or treater has
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        this.name = validName(name);
        this.age = validAge(age);
        this.numCandy = validNumCandy(numCandy);
    }

    /**
     * Helper method to test if a name is valid.
     * @param n String representing a Trick or treater's name
     * @return A valid name
     */
    private String validName(String n) {
        return ((n == null || n.isEmpty() || n.isBlank()) ? "Charlie Brown" : n);
    }

    /**
     * Helper method to test if a age is valid.
     * @param a int representing a Trick or treater's age
     * @return A valid age
     */
    private int validAge(int a) {
        return ((a < 0 || a > 12) ? 8 : a);
    }

    /**
     * Helper method to test if an amount of candy is valid.
     * @param nC int representing a the amount of candy a Trick or treater has
     * @return A valid amount of candy
     */
    private int validNumCandy(int nC) {
        return ((nC < 0) ? 0 : nC);
    }

    /** Abstract method representing trick or treating.
     */
    public abstract void trickOrTreat();

    /**
     * A method that represents candy being gained.
     * @param candy int representing the amount of candy to add
     */
    protected void gainCandy(int candy) {
        if (candy >= 0) {
            numCandy += candy;
        }
    }

    /**
     * A method that represents candy being lost.
     * @param candy int representing the amound of candy to lose
     * @return
     */
    protected int loseCandy(int candy) {
        int lost = 0;

        if (candy <= 0) {
            return 0;
        } else if (candy >= numCandy) {
            lost = numCandy;
            numCandy = 0;
            return lost;
        } else if (candy < numCandy) {
            lost = candy;
            numCandy -= candy;
            return lost;
        }
        return -1;
    }

    /** Method to return a string in a given format, overridden from Object class.
     * @return a string in a format describing an instance of TrickOrTreater
     */
    @Override
    public String toString() {
        return String.format("%s/%d/%d", this.name, this.age, this.numCandy);
    }

    /** Method that compares two TrickOrTreater objects, overridden for Comparable class.
     * @return an integer that compares two TrickOrTreater objects
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        return (this.numCandy != other.numCandy ? this.numCandy - other.numCandy : this.age - other.age);
    }

    /**
     * Getter method that returns the amount of candy a trick or treater has.
     * @return an integer representing the amount of candy a trick or treater has
     */
    public int getNumCandy() {
        return numCandy;
    }
}
