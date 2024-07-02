package HW02;
/**
 * Represents a class of Fish called Aquarium.
 * @author Rachel Lee
 * @version 1.0
 */

public class Aquarium {
    /** Driver class to test the Fish.java, Catfish.java, StripedBass.java, and FLyingFish.java.
     * @param args Array of type String
    */
    public static void main(String[] args) {
        Fish test1 = new Fish("", 10.0, 23.0);
        Catfish test2 = new Catfish("test2", 25.0, 3492.3, 20.0);
        StripedBass test3 = new StripedBass("test3", 3.23, 123.0, -5, true, test2);
        FlyingFish test4 = new FlyingFish();

        System.out.println(test1.formatLength());
        System.out.println(test1.formatWeight());

        System.out.println(test2.isShaggy());

        System.out.println("Before Migration: " + test3);
        test3.migrate();
        System.out.println("After Migration: " + test3);

        System.out.println(test4.calculatePower());
        test4.fly();

        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());
        System.out.println(test4.toString());
    }
}