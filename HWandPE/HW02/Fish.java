package HW02;
/**
 * Represents a Fish with attributes of name, length, and weight.
 * @author Rachel Lee
 * @version 1.0
 */

public class Fish {
    protected final String name;
    protected Double length;
    protected Double weight;
    private static int totalFish = 0;

    /** A constructor that creates an object Fish with three parameters.
     * @param n The name of the fish as a String
     * @param l The length of the fish as a Double
     * @param w The weight of the fish as a Double
     */
    public Fish(String n, Double l, Double w) {

        name = validName(n);
        length = validLength(l);
        weight = validWeight(w);
        totalFish++;

    }

    /** A default constructor that creates an object Fish with no parameters.
     */
    public Fish() {
        this("Nemo", 5.0, 12.0);
        totalFish++;
    }

    /** A deep copy constructor that creates a new Fish based on another Fish instance.
     * @param fish Instance of Fish that is being copied
    */
    public Fish(Fish fish) {
        this(fish.name, fish.length, fish.weight);
        totalFish++;
    }

    /** Tests if a given name is valid.
     * @param n The name that is being tested
     * @return A valid name. If the given name is invalid, return "Nemo"
     */
    private String validName(String n) {
        if (n == null || n.isEmpty() || n.isBlank()) {
            return "Nemo";
        }
        return n;
    }

    /** Tests if a given length is valid.
     * @param l The length that is being tested
     * @return A valid length. If the given length is invalid, return 8.0
     */
    private Double validLength(Double l) {
        if (l == null || Double.isNaN(l) || Double.isInfinite(l) || l <= 0) {
            return 8.0;
        }
        return l;
    }

    /** Tests if a given weight is valid.
     * @param w The weight that is being tested
     * @return A valid weight. If the given weight is invalid, return 2.0
    */
    private Double validWeight(Double w) {
        if (w == null || Double.isNaN(w) || Double.isInfinite(w) || w <= 0) {
            return 2.0;
        }
        return w;
    }

    /** Returns the length of the fish as a String in a specific format.
     * @return The length formatted as [feet] ft [inches] in
     */
    public String formatLength() {
        double l = length;
        int ft = (int) l / 12;
        double in = length - (ft * 12);
        String out = String.format("%d ft %.2f in", ft, in);
        return out;
    }

    /** Returns the weight of the fish as a String in a specific format.
     * @return The weight formatted as [pounds] lb(s) [ounces] oz
     */
    public String formatWeight() {
        String out;
        double w = weight;
        int lb = (int) w / 16;
        //System.out.println("lb = " + lb);
        double oz = weight - (lb * 16);
        out = String.format("%d %s %.2f oz", lb, lb == 1 ? "lb" : "lbs", oz);
        return out;
    }

    /** Returns a String describing the name, length, and weight of the Fish.
     * @return The Fish attributes formatted
    */
    @Override
    public String toString() {
        String l = formatLength();
        String w = formatWeight();
        String out = String.format("I'm a talking fish named %s. My length is %s and my weight is %s.", name, l, w);
        return out;
    }
}
