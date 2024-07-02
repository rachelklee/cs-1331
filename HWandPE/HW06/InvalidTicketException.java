/**
 * Class describing a unchecked InvalidTicketException.
 * @author Rachel Lee
 * @version 1.0
 */
public class InvalidTicketException extends Exception {
    private String exceptionMessage;

    /**
     * A constructor for a InvalidTicketException with 1 parameters.
     * @param exceptionMessage String representing the exception message
     */
    public InvalidTicketException(String exceptionMessage) {
        super(exceptionMessage);
    }

    /**
     * A constructor for a InvalidTicketException with no parameters.
     */
    public InvalidTicketException() {
        this("Invalid ticket");
    }
}
