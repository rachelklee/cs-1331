package HW05;
/**
 * Class describing a video game that can be checked out, extends the Media class.
 * @author Rachel Lee
 * @version 1.0
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    /**
     * A constructor for an object of type VideoGame that takes in 6 parameters.
     * @param genre Genre type representing a genre of the media
     * @param name String representing the name of the media
     * @param rating integer representing the rating of the media
     * @param rentalPrice double represent the price to rent the Media item
     * @param maxPlayers integer representing the maximum number of players in the game at once
     * @param needsConsole boolean representing whether or not the video game needs a gaming console
     * */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * A constructor for an object of type VideoGame that takes in 3 parameters.
     * @param genre Genre type representing a genre of the media
     * @param name String representing the name of the media
     * @param rating integer representing the rating of the media
     * */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    /** Method to return a string in a given format, overridden from Media class.
     * @return a string in a format describing an instance of VideoGame
     */
    @Override
    public String toString() {
        return String.format("%s, Players: %d, %s need console",
        super.toString(), this.maxPlayers, this.needsConsole ? "does" : "does not");
    }

    /** Method to test if two objects are equal to one another, overridden from Media class.
     * @param o represents the object to compare
     * @return boolean representing whether or not two instances of VideoGame are equal
     */
    @Override
    public boolean equals(Object o) {
        boolean s = super.equals(o);

        if (o == null || !o.getClass().equals(this.getClass())) {
            return false;
        } else {
            VideoGame v = (VideoGame) o;
            return s && this.maxPlayers == v.maxPlayers && this.needsConsole == v.needsConsole;
        }
    }

    /**
     * Getter method that returns whether or not a game requires a console.
     * @return a boolean representing whether or not a game requires a console
     */
    public boolean getNeedsConsole() {
        return needsConsole;
    }
}
