package HW08;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList class.
 * @author Rachel Lee
 * @version 1.0
 * @param <T> the type of elements in this LinkedList
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * No argument constructor.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * One argument constructor.
     * @param data array of type T
     * @throws IllegalArgumentException if the passed array is null or has null elements
     */
    public LinkedList(T[] data) throws IllegalArgumentException {
        if (nullArray(data)) {
            throw new IllegalArgumentException("Input array cannot be null or contain null elements.");
        }
        for (T datum : data) {
            add(datum); // keep adding to end
        }
    }

    /**
     * Helper method to test if an array is null or contains null elements.
     * @param input array of type T to test
     * @return whether or not the array is null or contains null elements
     */
    private boolean nullArray(T[] input) {
        if (input == null) {
            return true;
        }
        for (T element : input) {
            if (element == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Getter method to return head.
     * @return head node
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Method to return LinkedList as array.
     * @return array that stores generic type T representation of LinkedList
     */
    public T[] toArray() {
        Iterator<T> iterator = this.iterator();
        T[] out = (T[]) new Object[this.size];
        int index = 0;
        while (iterator.hasNext()) {
            out[index] = iterator.next();
            ++index;
        }

        return out;
    }

    /**
     * Method to return LinkedList as a string.
     * @return string representation of LinkedList
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    /**
     * Inserts the element at the end of the list.
     * @param element the element we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Inserts the element at the specified index of the list.
     * If an element exists at that index, that element in the list should come after the new element being added.
     * @param index   the index to add the element at
     * @param element the element we are adding to the list
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index == size() is valid.
     *                                   In the event both arguments are invalid, this exception should be thrown.
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index to add element");
        }

        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Removes the element at the front of the list and returns it.
     * @return the removed element from the front of the list
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Element cannot be null");
        }
        if (head == null && size != 0) {
            throw new NoSuchElementException("Element cannot be null");
        }
        if (head == null && size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if (size < 0) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index the index of the element to be removed
     * @return the removed element at the specified index of the list
     * @throws NoSuchElementException    if the list is empty. In the event that the list is empty and
     *                                   the passed in index is invalid, this exception should be thrown.
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (index < 0 && size != 0) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        if (head == null && size != 0) {
            throw new NoSuchElementException("Element cannot be null");
        }
        if (head == null && size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Element is out of bounds of LinkedList");
        }
        if (index == 0) {
            return remove();
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        T data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return data;
    }

    /**
     * Removes the first occurrence of the specified element from the list and returns it.
     * The first occurrence of the specified element is the first element in the list
     * that is equal to the passed in element according to how the equals method is defined.
     * @param element the element to be removed
     * @return the element that is removed from the list. Do not return the passed in element!
     * @throws IllegalArgumentException if the passed in element is null
     * @throws NoSuchElementException   if the passed in element is not in the list. If the passed in element
     *                                  is null, an IllegalArgumentException should be thrown instead.
     */
    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        if (head == null && size != 0) {
            throw new IllegalArgumentException("Head cannot be null");
        }

        if (head == null && size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.getData().equals(element)) {
            return remove();
        }
        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(element)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            throw new NoSuchElementException("Element not found");
        }
        T data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return data;
    }

    /**
     * Replaces the element at a specific index with the passed in element.
     * @param index   the index of the element to be replaced
     * @param element the element that should replace the existing element at the passed in index
     * @return the element that was replaced
     * @throws IndexOutOfBoundsException if the passed in index is invalid.
     *                                   In the event both arguments are invalid, this exception should be thrown.
     * @throws IllegalArgumentException  if the passed in element is null
     */
    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T oldData = current.getData();
        current.setData(element);
        return oldData;
    }

    /**
     * Returns the element at the specified index.
     * @param index the index of the element to get
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Checks if the list contains the specified element.
     * The list contains the specified element if there exists at least one element in the list
     * that is equal to the passed in element according to how the equals method is defined.
     * @param element the element to search for in the list
     * @return whether the list contains the element
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     * @return whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Overrides Iterator class.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            /**
             * Checks if LinkedList has next node.
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Returns next node in LinkedList if exists.
             * @throws NoSuchElementException if the next node does not exist
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Next node does not exist");
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}