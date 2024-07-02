package HW08;
/**
 * Generic class representing individual node.
 * @author Rachel Lee
 * @version 1.0
 * @param <T> the type of elements in this Node
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Two aregument constructor.
     * @param data generic type T to be stored in the node
     * @param next reference to the next Node
     * @throws IllegalArgumentException if the passed array is null or has null elements
     */
    public Node(T data, Node<T> next) throws IllegalArgumentException {
        this(data);
        if (data == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        this.next = next;
    }

    /**
     * One argument constructor.
     * @param data generic type T to be stored in the node
     * @throws IllegalArgumentException if the passed array is null or has null elements
     */
    public Node(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        this.data = data;
        this.next = null;
    }

    /**
     * Getter method for data in a node.
     * @return the data in a node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Setter method to set data in a node.
     * @param element generic type T to be stored in the node
     * @throws IllegalArgumentException if the passed array is null or has null elements
     */
    public void setData(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        this.data = element;
    }

    /**
     * Getter method for the reference to the next node.
     * @return the reference to the next node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Setter method for the reference to the next node.
     * @param element the reference to set the next node to
     */
    public void setNext(Node<T> element) {
        this.next = element;
    }
}