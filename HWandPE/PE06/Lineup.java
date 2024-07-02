package PE06;
import java.util.ArrayList;

/**
 * A generic class representing a lineup of maximum size 4.
 * @author Rachel Lee
 * @version 1.0
 * @param <T> the type of elements in the Lineup
 */
public class Lineup<T extends Comparable<T>> {
    private ArrayList<T> lineup;
    private boolean isAscending;

    /**
     * Four parameter constructor.
     * @param first T entry in the lineup
     * @param second T entry in the lineup
     * @param third T entry in the lineup
     * @param fourth T entry in the lineup
     * @throws NullPointerException if null argument is passed in
     */
    public Lineup(T first, T second, T third, T fourth) throws NullPointerException {
        this.lineup = new ArrayList<T>(4);

        if (first == null || second == null || third == null || fourth == null) {
            throw new NullPointerException("Arguments contain null");
        } else {
            lineup.add(0, first);
            lineup.add(1, second);
            lineup.add(2, third);
            lineup.add(3, fourth);
            this.isAscending = true;
        }
    }

    /**
     * Method to return the lineup as a string.
     * @return string representation of the lineup
     */
    @Override
    public String toString() {
        String result = new String();

        for (int i = 0; i < this.lineup.size(); ++i) {
            T item = lineup.get(i);
            String itemStr = (item != null) ? (String) item : null;
            result.concat(itemStr);

            if (i < lineup.size() - 1) {
                result.concat(" -> ");
            }
        }

        return result;
    }

    /**
     * Method to add an element to the lineup.
     * @param element to add to the lineup
     * @return whether or not the element was successfully added to the lineup
     * @throws IllegalArgumentException if argument is null
     */
    public boolean add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Cannot add null element");
        }

        for (int i = 0; i < this.lineup.size(); ++i) {
            int filled = 0;
            for (T item : this.lineup) {
                if (item == null) {
                    return false;
                } else {
                    ++filled;
                }
            }
            if (filled == 4) {
                return false;
            }

            T item = lineup.get(i);
            if (isAscending) {
                if (((String) element).compareTo((String) item) <= 0) {
                    this.lineup.add(i, item);
                    return true;
                }
            }
            if (!isAscending) {
                if (((String) element).compareTo((String) item) >= 0) {
                    this.lineup.add(i, item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to remove the first occurence of an element.
     * @param element to remove from lineup
     * @return whether or not the element was successfully removed from the lineup
     */
    public boolean remove(T element) {
        for (T item : this.lineup) {
            if (item.equals(element)) {
                this.lineup.remove(item);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to reverse the lineup's ordering.
     */
    public void reverseLineup() {
        recursiveReverse(this.lineup);
        if (isAscending) {
            isAscending = false;
        } else {
            isAscending = true;
        }
    }

    /**
     * Helper method to recursively reverse the lineup.
     * @param <T> Generic type of lineup
     * @param list Arraylist representing the array to reverse
     */
    public static <T> void recursiveReverse(ArrayList<T> list) {
        if (list.size() > 1) {
            T value = list.remove(0);
            recursiveReverse(list);
            list.add(value);
        }
    }

    /**
     * Tests whether the lineup contains the specified element.
     * @param element T to find in lineup
     * @return whether or not element was found
     */
    public boolean contains(T element) {
        for (T item : this.lineup) {
            if (item.equals(lineup)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find the size of the lineup.
     * @return the integer size of the lineup
     */
    public int size() {
        int size = 0;
        for (T item : this.lineup) {
            if (!(item == null)) {
                ++size;
            }
        }
        return size;
    }

    /**
     * Main method.
     * @param args arguments for main method
     */
    public static void main(String[] args) {
        Lineup<Integer> lineup1 = new Lineup(null, null, null, null);
        Integer first = 10;
        Integer second = 32;
        Integer third = 34;
        lineup1.add(first);
        lineup1.add(second);
        lineup1.reverseLineup();
        lineup1.contains(third);
        lineup1.size();

        Lineup<String> lineup2 = new Lineup("First", "Second", "Third", "Fourth");
        lineup2.remove("First");
        lineup2.toString();
    }
}
