/**
 * An abstract class representing a SportsGame.
 * @author Rachel Lee
 * @version 1.0
 */
public abstract class SportsGame {
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;

    /**
     * A constructor for an object of type SportsGame that takes in 6 parameters.
     * @param venue String type representing a venue
     * @param startTime String type representing the start time
     * @param startDate String type representing the start date
     * @param score1 integer type representing the first score
     * @param score2 integer type representing the second score
     * @param seatsLeft integer type representing the number of seats left
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft)
        throws IllegalArgumentException {
        this.venue = validString(venue);
        this.startTime = validString(startTime);
        this.startDate = validString(startDate);
        this.score1 = validNum(score1);
        this.score2 = validNum(score2);
        this.seatsLeft = validNum(seatsLeft);
    }

    /**
     * A helper method to test whether a string is valid.
     * @param str String type representing a string to test
     * @return a valid string
     */
    public String validString(String str) throws IllegalArgumentException {
        if (str == null || str.isEmpty() || str.isBlank()) {
            throw new IllegalArgumentException("Empty or Null String is Invalid");
        } else {
            return str.trim();
        }
    }

    /**
     * A helper method to test whether a number is valid.
     * @param num integer type representing a number to test
     * @return a valid number
     */
    private int validNum(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Negative Number is Invalid");
        } else {
            return num;
        }
    }

    /** Method to return a string in a given format, overridden from Object class.
     * @return a string in a format describing an instance of SportsGame
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%d,%d",
            this.venue, this.startTime, this.startDate, this.score1, this.score2, this.seatsLeft);
    }

    /** Method to test if two objects are equal to one another, overridden from Object class.
     * @param o represents the object to compare
     * @return boolean representing whether or not two instances of SportsGame are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            SportsGame s = (SportsGame) o;
            return this.venue.equals(s.venue) && this.startTime.endsWith(s.startTime)
                && this.startDate.equals(s.startDate)
                && this.score1 == s.score1 && this.score2 == s.score2 && this.seatsLeft == s.seatsLeft;
        } else {
            return false;
        }
    }

    /**
     * A getter method to get the number of seats left.
     * @return seatsLeft
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }
}