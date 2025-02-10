public class Node {
    private int value;
    private Node nextElement;
    private Node prevElement;

    public Node(int value) {
        this.value = value;
        this.nextElement = null;
        this.prevElement = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node nextElement) {
        this.nextElement = nextElement;
    }

    public Node getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(Node prevElement) {
        this.prevElement = prevElement;
    }
}
