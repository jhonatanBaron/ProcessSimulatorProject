package so.util.queue;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 24/03/20
 */
public class Node<T> {

    private T data;

    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
