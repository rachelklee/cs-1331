package HW05;
/**
 * Class describing a movie that can be checked out, extends the Media class.
 * @author Rachel Lee
 * @version 1.0
 */
public class Movie extends Media {
    private int runtime;

    /**
     * A constructor for an object of type Movie that takes in 5 parameters.
     * @param genre Genre type representing a genre of the media
     * @param name String representing the name of the media
     * @param rating integer representing the rating of the media
     * @param rentalPrice double representing the rental price of the media
     * @param runtime integer representing the runtime of the movie
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * A constructor for an object of type Movie that takes in 3 parameters.
     * @param genre Genre type representing a genre of the media
     * @param name String representing the name of the media
     * @param rating integer representing the rating of the media
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    /** Method to return a string in a given format, overridden from Media class.
     * @return a string in a format describing an instance of Movie
     */
    @Override
    public String toString() {
        return String.format("%s, Runtime: %d", super.toString(), this.runtime);
    }

    /** Method to test if two objects are equal to one another, overridden from Media class.
     * @param o represents the object to compare
     * @return boolean representing whether or not two instances of Media are equal
     */
    @Override
    public boolean equals(Object o) {
        boolean s = super.equals(o);

        if (o == null || !o.getClass().equals(this.getClass())) {
            return false;
        } else {
            Movie m = (Movie) o;
            return s && this.runtime == m.runtime;
        }
    }
}
