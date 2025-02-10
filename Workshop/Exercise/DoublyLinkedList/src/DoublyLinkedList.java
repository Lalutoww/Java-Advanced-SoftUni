public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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

    private boolean isEmpty() {
        return this.size == 0;
    }

}
