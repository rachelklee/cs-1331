package HW02;
/**
 * Represents a child class of Fish called Catfish.
 * @author Rachel Lee
 * @version 1.0
 */

public class Catfish extends Fish {
    private Double whiskerLength;

    /** A constructor that creates an object Catfish with four parameters.
     * @param n The name of the Catfish as a String
     * @param l The length of the Catfish as a Double
     * @param w The weight of the Catfish as a Double
     * @param wl the Whisker Length of the Catfish as a Double
     */
    public Catfish(String n, Double l, Double w, Double wl) {
        super(n, l, w);

        if (wl == null || wl.isNaN() || wl.isInfinite() || wl <= 0) {
            whiskerLength = 8.0;
        } else {
            whiskerLength = wl;
        }
    }

    /** A default constructor that creates an object Catfish with no parameters.
     */
    public Catfish() {
        this("Bubba", 52.0, 720.0, 5.0);
    }

    /** A deep copy constructor that creates a new Catfish based on another Catfish instance.
     * @param c Instance of Catfish that is being copied
    */
    public Catfish(Catfish c) {
        this(c.name, c.length, c.weight, c.whiskerLength);

        if (c.whiskerLength.isNaN() || c.whiskerLength.isInfinite()
            || c.whiskerLength <= 0 || c.whiskerLength == null) {
            this.whiskerLength = 8.0;
        } else {
            this.whiskerLength = c.whiskerLength;
        }
    }

    /** Tests if a Catfish is shaggy.
     * @return Whether or not a Catfish is shaggy
     */
    public boolean isShaggy() {
        if (whiskerLength > super.length) {
            return true;
        }
        return false;
    }

    /** Returns a String describing the name, length, weight, whisker length, and shagginess of the Catfish.
     * @return The Catfish attributes formatted
    */
    @Override
    public String toString() {
        String s = isShaggy() ? "am" : "am not";
        String out = String.format("%s I'm a catfish whose longest whisker is %.2f, so I %s shaggy.",
            super.toString(), whiskerLength, s);
        return out;
    }

    /** Set the whisker lenght of the Catfish.
     * @param w The whiskger length of the Catfish as a Double
     */
    public void setWhiskerLength(Double w) {
        if (w == null || w <= 0 || w.isNaN() || w.isInfinite()) {
            whiskerLength = 8.0;
        } else {
            whiskerLength = w;
        }
    }
}
