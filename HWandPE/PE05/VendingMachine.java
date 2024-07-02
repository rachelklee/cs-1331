package PE05;
import java.util.ArrayList;

/**
 * Class describing a vending machine.
 * @author Rachel Lee
 * @version 1.0
 */
public class VendingMachine {
    private ArrayList<String> stock;
    private int cost;

    /**
     * A constructor for an object of type VendingMachine that takes in 2 parameters.
     * @param stock ArrayList that holds objects of String type representing the stock in the vending machine
     * @param cost integer type representing the cost of an item in cents
     */
    public VendingMachine(ArrayList<String> stock, int cost) {
        this.stock = stock;
        this.cost = cost;
    }

    /**
     * A method to check whether or not all items in order are in stock.
     * @param order ArrayList that holds objects of String type representing an order
     * @throws IllegalArgumentException Exception thrown if the input is null
     * @throws OutOfStockException Exception thrown if item in order is not found in stock
     */
    public void checkStock(ArrayList<String> order) throws IllegalArgumentException, OutOfStockException {
        if (order == null) {
            throw new IllegalArgumentException("Order is invalid");
        }
        for (String o : order) {
            if (!stock.contains(o)) {
                throw new OutOfStockException(o);
            }
        }
        System.out.println("All items are in stock!");
    }

    /**
     * A method that represents an item being purchased.
     * @param item String representing an item to buy
     * @param money Integer representing how many cents a customer has
     * @throws IllegalArgumentException Exception thrown if the input is null
     * @throws OutOfStockException Exception thrown if item in order is not found in stock
     * @throws NotEnoughMoneyException Exception thrown if a customer doesn't have enough money to buy an item they want
     */
    public void buyItem(String item, int money)
        throws IllegalArgumentException, OutOfStockException, NotEnoughMoneyException {

        if (item == null) {
            throw new IllegalArgumentException("Invalid item");
        }

        if (money < cost) {
            throw new NotEnoughMoneyException();
        }

        ArrayList<String> checkItem = new ArrayList<>();
        checkItem.add(item);
        checkStock(checkItem);

        System.out.printf("%d successfully vended!\n", item);
    }

    /**
     * A method that sees which favorites are in stock.
     * @param favoriteItems ArrayList that holds String type representing a customers favorite items
     * @return ArrayList holding String type that represents the available favorites
     * @throws OutOfStockException Exception thrown if item in order is not found in stock
     * @throws IllegalArgumentException Exception thrown if the input is null
     */
    public ArrayList<String> availableFavorites(ArrayList<String> favoriteItems)
        throws OutOfStockException, IllegalArgumentException {
        ArrayList<String> available = new ArrayList<String>();

        if (favoriteItems == null) {
            throw new IllegalArgumentException("Item invalid");
        }

        for (String f : favoriteItems) {
            if (stock.contains(f)) {
                available.add(f);
            }
        }

        return available;
    }

    /**
     * Main method for testing.
     * @param args Arguments array of type String
     */
    public static void main(String[] args) {
        ArrayList<String> vendingItems = new ArrayList<>(5);
        vendingItems.add(new String("item 1"));
        vendingItems.add(new String("item 2"));
        vendingItems.add(new String("item 3"));
        vendingItems.add(new String("item 4"));
        vendingItems.add(new String("item 5"));

        ArrayList<String> favorites = new ArrayList<>(3);
        favorites.add(new String("favorite 1"));
        favorites.add(new String("favorite 2"));
        favorites.add(new String("favorite 3"));

        VendingMachine v = new VendingMachine(vendingItems, 10);

        try {
            v.checkStock(vendingItems);
            v.buyItem("item 1", 3);
            v.buyItem("item 2", 100);
            v.buyItem("item 7", 1);
            v.buyItem("item 7", 100);

            for (String s : v.availableFavorites(favorites)) {
                System.out.println(s);
            }
        } catch (OutOfStockException o) {
            System.out.println(o);
        } catch (NotEnoughMoneyException n) {
            System.out.println(n);
        } finally {
            System.out.println("Took a trip to the vending machine!");
        }
    }
}
