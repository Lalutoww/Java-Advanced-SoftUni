import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

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

    public void forEach(Consumer<T> consumer) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.getValue());
            currentNode = currentNode.getNextElement();
        }
    }

    public List<T> toList() {
        List<T> nodeList = new ArrayList<>();
        forEach(nodeList::add);
        return nodeList;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds.", index));
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

}
