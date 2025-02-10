import java.util.NoSuchElementException;

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
        this.checkIfEmpty();
        int removedElement = this.data[size - 1];
        size--;

        if (capacity / 4 > size) {
            this.shrink();
        }
        return removedElement;
    }

    /**
     * Retrieves, but does not remove, the last element represented by
     * this stack, or returns {@code null} if this deque is empty.
     *
     * @return the last element represented by this stack
     * @throws NoSuchElementException if there are no elements in the stack
     */
    public int peek() {
        this.checkIfEmpty();
        return this.data[size - 1];
    }

    /**
     * Checks the size of the stack and throws an exception if it is empty.
     *
     * @throws NoSuchElementException if there are no elements in the stack.
     */
    private void checkIfEmpty() {
        if (this.size < 1) {
            throw new NoSuchElementException("There are no elements in the stack");
        }
    }


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
