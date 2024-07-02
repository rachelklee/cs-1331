package HW08;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic class representing an iterator to iterate over a LinkedList.
 * @author Rachel Lee
 * @version 1.0
 * @param <T> the type of elements in this Iterator
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    /**
     * One element constructor.
     * @param linkedList LinkedList to iterate over
     * @throws IllegalArgumentException if the passed array is null or has null elements
     */
    public LinkedListIterator(LinkedList<T> linkedList) throws IllegalArgumentException {
        if (linkedList == null) {
            throw new IllegalArgumentException("Linked List cannot be null.");
        }

        this.next = linkedList.getHead();
    }

    /**
     * Specifies whether or not there are more nodes to iterate over.
     * @return boolean representing if there is a following node
     */
    @Override
    public boolean hasNext() {
        return next != null;
    }

    /**
     * Reterns the next data in the iteration and advances the iterator.
     * @return T data in the next node
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes");
        }

        T data = next.getData();
        next = next.getNext();
        return data;
    }
}