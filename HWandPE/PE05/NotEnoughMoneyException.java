package PE05;
/**
 * Class describing a unchecked NotEnoughMoneyException.
 * @author Rachel Lee
 * @version 1.0
 */
public class NotEnoughMoneyException extends RuntimeException {

    /**
     * A constructor for a NotEnoughMoneyException.
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}
