package PE05;
/**
 * Class describing a checked OutOfStockException.
 * @author Rachel Lee
 * @version 1.0
 */
public class OutOfStockException extends Exception {

     /**
      * A constructor for an OutOfStockException.
      * @param item String type representing an item in stock
      */
    public OutOfStockException(String item) {
        super(String.format("%s is not in stock.", item));
    }
}
