public class CustomStack {
    /**
     * initial stack capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * initial stack size.
     */
    private static final int DEFAULT_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.size = DEFAULT_SIZE;
        this.capacity = DEFAULT_CAPACITY;
        this.data = new int[DEFAULT_CAPACITY];
    }

    /**
     * Inserts the specified element at the top of the stack.
     *
     * @param element the element to add
     */
    public void push(int element) {
        if (size >= capacity) {
            this.resize();
        }

        this.data[size] = element;
        size++;
    }

    public int pop() {
        int removedElement = this.data[size - 1];
        size--;

        if (capacity / 4 > size) {
            this.shrink();
        }
        return removedElement;
    }

    public int peek() {
        return this.data[size - 1];
    }

    //foreach(Consumer)

    /**
     * Decreases the capacity of this stack by 2 each time {@code capacity / 4 > size}.
     */
    private void shrink() {
        this.capacity /= 2;
        int[] temp = new int[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, size);
        this.data = temp;
    }

    /**
     * Increases the capacity of this stack by 2 each time {@code size == capacity}.
     */
    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, size);
        this.data = temp;
    }
}
