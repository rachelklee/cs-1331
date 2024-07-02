package HW04;
/**
 * Represents a class Witch that extends the abstract class TrickOrTreater.
 * @author Rachel Lee
 * @version 1.0
 */
public class Witch extends TrickOrTreater implements Robbable  {
    private String signatureCackle = "Bwahaha";

    /** A constructor that creates an object Witch with 4 parameters.
     * @param name String representing the Witch's name
     * @param age integer representing the Witch's age
     * @param numCandy integer representing the amount of candy the Witch has
     * @param signatureCackle String rperesenting the Witch's signature cackle
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        this.signatureCackle = validCackle(signatureCackle);
    }

    /** A constructor that creates an object Witch with no parameters.
     */
    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    /**
     * Helper method to test if a cackle is valid.
     * @param cackle String representing the cackle being tested
     * @return a valid cackle
     */
    private String validCackle(String cackle) {
        if (cackle == null || cackle.equals("") || cackle.isBlank() || cackle.isEmpty()) {
            cackle = "Bwahaha";
        }
        return (cackle.trim().equals(cackle) ? cackle : "Bwahaha");
    }

    /**
     * A method that implements the abstract method in the parent class TrickOrTreater.
     */
    public void trickOrTreat() {
        System.out.printf("%s! I'll get you my pretty!\n", signatureCackle);
        super.gainCandy(3);
    }

    /** Method that compares two Witch objects, overridden from TrickOrTreater class.
     * @return an integer that compares two Witch objects
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        int comp = super.compareTo(other);
        if (comp == 0 && this.getClass() == other.getClass()) {
            return this.signatureCackle.length() - ((Witch) other).signatureCackle.length();
        }
        return comp;
    }

    /**
     * A method that robs a witch.
     * @return The amount of candy stolen
     */
    public int beRobbed() {
        int numCandy = getNumCandy();
        int candyLost = 0;
        if (numCandy >= 6) {
            this.loseCandy(6);
            candyLost = 6;
        } else {
            candyLost = numCandy;
            this.loseCandy(numCandy);
        }
        return candyLost;
    }
}
