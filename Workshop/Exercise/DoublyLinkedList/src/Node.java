public class Node<T> {
    private final T value;
    private Node<T> nextElement;
    private Node<T> prevElement;

    public Node(T value) {
        this.value = value;
        this.nextElement = null;
        this.prevElement = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }

    public Node<T> getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(Node<T> prevElement) {
        this.prevElement = prevElement;
    }
}
