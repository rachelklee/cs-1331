/**
 * A class representing a BasketballGame that is a child of SportsGame.
 * @author Rachel Lee
 * @version 1.0
 */
public class BasketballGame extends SportsGame {
    private String league;

    /**
     * A constructor for an object of type BasketballGame that takes in 7 parameters.
     * @param venue String type representing a venue
     * @param startTime String type representing the start time
     * @param startDate String type representing the start date
     * @param score1 integer type representing the first score
     * @param score2 integer type representing the second score
     * @param seatsLeft integer type representing the number of seats left
     * @param league String type representing the league
     */
    public BasketballGame(String venue, String startTime, String startDate,
        int score1, int score2, int seatsLeft, String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        this.league = validString(league);
    }

    /** Method to return a string in a given format, overridden from SportsGame class.
     * @return a string in a format describing an instance of BasketballGame
     */
    @Override
    public String toString() {
        return String.format("BasketballGame,%s,%s", super.toString(), this.league);
    }

    /** Method to test if two objects are equal to one another, overridden from SportsGame class.
     * @param o represents the object to compare
     * @return boolean representing whether or not two instances of BasketballGame are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            BasketballGame b = (BasketballGame) o;
            return super.equals(o) && this.league.equals(b.league);
        } else {
            return false;
        }
    }

    /**
     * A getter method to get the league.
     * @return league
     */
    public String getLeague() {
        return league;
    }
}
