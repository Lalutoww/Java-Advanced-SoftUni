import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    private static final int DEFAULT_SIZE = 0;

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructs the linkedList by setting the head and tail to null, and sets the size.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = DEFAULT_SIZE;
    }

    /**
     * adds T as first element.
     *
     * @param element element to be added.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.setPrevElement(newNode);
            newNode.setNextElement(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Adds T as last element.
     *
     * @param element element to be added.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            addFirst(element);
        } else {
            this.tail.setNextElement(newNode);
            newNode.setPrevElement(this.tail);
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Gets the element at index position.
     *
     * @param index position of the element.
     * @throws IndexOutOfBoundsException if index is out of bound {@link #checkIndex}.
     */
    public T get(int index) {
        checkIndex(index);
        if (index == 0) {
            return this.head.getValue();
        } else if (index == size - 1) {
            return this.tail.getValue();
        }

        Node<T> currentNode = null;
        if (index <= size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextElement();
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                currentNode = this.tail;
                currentNode = currentNode.getPrevElement();
            }
        }

        assert currentNode != null;
        return currentNode.getValue();
    }

    /**
     * Removes the head element (first element).
     *
     * @return The value of the removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        } else {
            T removedNode = this.head.getValue();
            this.head = this.head.getNextElement();
            if (this.head == null) {
                this.tail = null;
            } else {
                this.head.setPrevElement(null);
            }
            this.size--;
            return removedNode;
        }
    }

    /**
     * Removes the tail element (last element).
     *
     * @return The value of the removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        } else {
            T removedNode = this.tail.getValue();
            this.tail = this.tail.getPrevElement();
            if (this.tail == null) {
                this.head = null;
            } else {
                this.tail.setNextElement(null);
            }
            this.size--;
            return removedNode;
        }
    }

    /**
     * Iterates through all elements in the linked list.
     *
     * @param consumer lambda function to be executed.
     */
    public void forEach(Consumer<T> consumer) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.getValue());
            currentNode = currentNode.getNextElement();
        }
    }

    /**
     * Puts all the node elements in a normal ArrayList.
     *
     * @return ArrayList filled with the nodes.
     */
    public List<T> toList() {
        List<T> nodeList = new ArrayList<>();
        forEach(nodeList::add);
        return nodeList;
    }

    /**
     * Checks if the index is in bounds.
     *
     * @param index the index to be checked.
     * @throws IndexOutOfBoundsException if the index is not present in the linked list.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds.", index));
        }
    }

    /**
     * Checks if the index is in bounds.
     *
     * @return boolean value -> {@code true} if is empty, and {@code false} otherwise.
     */
    private boolean isEmpty() {
        return this.size == 0;
    }

}
