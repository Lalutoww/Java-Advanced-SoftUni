public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        checkIndex(index);
        if (index == 0) {
            return this.head.getValue();
        } else if (index == size - 1) {
            return this.tail.getValue();
        }

        Node currentNode = null;
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

        return currentNode.getValue();
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
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

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            addFirst(element);
        } else {
            this.tail.setNextElement(newNode);
            newNode.setPrevElement(this.tail);
            this.tail = newNode;
        }
        this.size++;
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
