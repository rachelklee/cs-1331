package HW05;
/**
 * Abstract class defining the basic behaviors of media items a customer can check out.
 * @author Rachel Lee
 * @version 1.0
 */
public abstract class Media implements Comparable<Media> {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * A constructor for an object of type Media that takes in 4 parameters.
     * @param genre Genre type representing a genre of the media
     * @param name String representing the name of the media
     * @param rating integer representing the rating of the media
     * @param rentalPrice double representing the rental price of the media
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * A constructor for an object of type Media that takes in 3 parameters.
     * @param genre Genre type representing a genre of the media
     * @param name String representing the name of the media
     * @param rating integer representing the rating of the media
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    /** Method to return a string in a given format, overridden from Object class.
     * @return a string in a format describing an instance of TrickOrTreater
     */
    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f",
            this.genre, this.name, this.rating, this.rentalPrice);
    }

    /** Method to test if two objects are equal to one another, overridden from Object class.
     * @param o represents the object to compare
     * @return boolean representing whether or not two instances of Media are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(this.getClass())) {
            return false;
        } else {
            Media m = (Media) o;
            return this.genre == m.genre && this.name.equals(m.name)
                && this.rating == m.rating && this.rentalPrice == m.rentalPrice;
        }
    }

    /** Method that compares two Media objects, overridden for Comparable class.
     * @return an integer that compares two Media objects
     */
    @Override
    public int compareTo(Media other) {
        return (this.genre == other.genre && this.getName().equals(other.getName())
            ? this.getRating() - other.getRating() : (this.genre != other.genre
            ? this.genre.ordinal() - other.genre.ordinal() : this.getName().compareTo(other.getName())));
    }

    /**
     * Getter method that returns the name of a media.
     * @return a String representing the name of the media
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method that returns the rating of the media.
     * @return an integer representing the rating of the media
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Getter method that returns the rental price of the media.
     * @return a double representing the rental price of the media
     */
    public double getRentalPrice() {
        return this.rentalPrice;
    }
}
