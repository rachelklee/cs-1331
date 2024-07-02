package HW05;
import java.util.ArrayList;

/**
 * Class describing a Blockbuster store.
 * @author Rachel Lee
 * @version 1.0
 */
public class Blockbuster {
    private ArrayList<Media> inventory = new ArrayList<Media>();

    /**
     * A constructor for an object of type Blockbuster that takes in no parameters.
     */
    public Blockbuster() {
        this.inventory = new ArrayList<Media>();
    }

    /**
     * A method to add media items to the end of inventory.
     * @param m Media type representing non-null media items
     */
    public void addMedia(Media m) {
        inventory.add(m);
    }

    /**
     * A method to remove the first occurence of a media item.
     * @param m Media type representing non-null media items
     * @return The removed media item if removed
     */
    public Media removeMedia(Media m) {
        for (int i = 0; i < inventory.size(); ++i) {
            Media temp = inventory.get(i);
            if (temp.equals(m)) {
                inventory.remove(i);
                return temp;
            }
        }
        return null;
    }

    /**
     * A method that sorts the store's inventory in ascending order based on genre first, name second, and rating last.
     */
    public void sortMedia() {
        for (int i = 1; i < inventory.size(); ++i) {
            Media current = inventory.get(i);
            int compIdx = i - 1;

            while (compIdx >= 0 && inventory.get(compIdx).compareTo(current) > 0) {
                inventory.set(compIdx + 1, inventory.get(compIdx));
                 --compIdx;
            }
            inventory.set(compIdx + 1, current);
        }
    }

    /**
     * A method that takes a media item and finds it in the inventory.
     * @param m Media type rperesenting the item being searched for
     * @return the Media item being searched for if found
     */
    public Media findMedia(Media m) {
        int left = 0;
        int right = inventory.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (inventory.get(mid).equals(m)) {
                return inventory.get(mid);
            } else if (inventory.get(mid).compareTo(m) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /**
     * A method that returns the most popular movie based on audience rating.
     * @return Media item that is most popular
     */
    public Movie getMostPopularMovie() {
        Movie mp = null;
        int high = 0;
        if (inventory.size() == 0) {
            return null;
        }
        for (int i = 0; i < inventory.size(); ++i) {
            if (inventory.get(i) instanceof Movie) {
                if (inventory.get(i).getRating() > high) {
                    high = inventory.get(i).getRating();
                    mp = (Movie) inventory.get(i);
                } else if (inventory.get(i).getRating() == high) {
                    if (inventory.get(i).getName().compareTo(mp.getName()) < 0) {
                        high = inventory.get(i).getRating();
                        mp = (Movie) inventory.get(i);
                    }
                }
            }
        }
        return mp;
    }

}
