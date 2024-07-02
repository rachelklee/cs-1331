/**
 * A class representing a BasketballGame that is a child of FootballGame.
 * @author Rachel Lee
 * @version 1.0
 */
public class FootballGame extends SportsGame {
    private String performer;

    /**
     * A constructor for an object of type BasketballGame that takes in 7 parameters.
     * @param venue String type representing a venue
     * @param startTime String type representing the start time
     * @param startDate String type representing the start date
     * @param score1 integer type representing the first score
     * @param score2 integer type representing the second score
     * @param seatsLeft integer type representing the number of seats left
     * @param performer String type representing the performer
     */
    public FootballGame(String venue, String startTime, String startDate,
        int score1, int score2, int seatsLeft, String performer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        this.performer = validString(performer);
    }

    /** Method to return a string in a given format, overridden from SportsGame class.
     * @return a string in a format describing an instance of FootballGame
     */
    @Override
    public String toString() {
        return String.format("FootballGame,%s,%s", super.toString(), this.performer);
    }

    /** Method to test if two objects are equal to one another, overridden from SportsGame class.
     * @param o represents the object to compare
     * @return boolean representing whether or not two instances of FootballGame are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            FootballGame f = (FootballGame) o;
            return super.equals(o) && this.performer.equals(f.performer);
        } else {
            return false;
        }
    }

    /**
     * A getter method to get the performer.
     * @return performer
     */
    public String getPerformer() {
        return performer;
    }
}
