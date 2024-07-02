package HW05;
import java.util.ArrayList;

/**
 * Class describing Olivia's states and behaviors.
 * @author Rachel Lee
 * @version 1.0
 */
public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart = new ArrayList<Media>();
    private static boolean canUseConsole;

    /**
     * A method outlining behaviour of Olivia adding an item to her cart.
     * @param m non-null Media item Olivia wants to rent
     * @param b non-null Blockbuster store Olivia is shopping at
     * @return whether or not Olivia can add the item to her cart
     */
    public static boolean addToCart(Media m, Blockbuster b) {
        if (budget >= m.getRentalPrice() && b.findMedia(m) != null) {
            if (m instanceof Movie) {
                double cost = m.getRentalPrice();
                cart.add(b.removeMedia(m));
                budget -= cost;
                return true;
            }
            if (m instanceof VideoGame && canUseConsole) {
                double cost = m.getRentalPrice();
                cart.add(b.removeMedia(m));
                budget -= cost;
                return true;
            }
        }
        return false;
    }

    /**
     * A method outlining behaviour of Olivia changing her mind and removing an item from her cart.
     * @param m non-null Media item in Olivia's cart
     * @param b non-null Blockbuster store Olivia is shopping at
     */
    public static void changeMind(Media m, Blockbuster b) {
        for (int i = 0; i < cart.size(); ++i) {
            if (m.equals(cart.get(i))) {
                b.addMedia((Media) cart.get(i));
                cart.remove(i);
                budget += m.getRentalPrice();
                break;
            }
        }
    }
}
