import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack<T> implements Iterable<T> {
    /**
     * initial stack capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * initial stack size.
     */
    private static final int DEFAULT_SIZE = 0;

    private T[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CustomStack() {
        this.size = DEFAULT_SIZE;
        this.capacity = DEFAULT_CAPACITY;
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Inserts the specified element at the top of the stack.
     *
     * @param element the element to add
     */
    public void push(T element) {
        if (size >= capacity) {
            this.resize();
        }

        this.data[size] = element;
        size++;
    }

    public T pop() {
        this.checkIfEmpty();
        T removedElement = this.data[size - 1];
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
    public T peek() {
        this.checkIfEmpty();
        return this.data[size - 1];
    }


    public void forEach(Consumer<? super T> consumer) {
        for (int i = this.size - 1; i >= 0; i--) {
            consumer.accept(this.data[i]);
        }
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
    @SuppressWarnings("unchecked")
    private void shrink() {
        this.capacity /= 2;
        T[] temp = (T[]) new Object[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, size);
        this.data = temp;
    }

    /**
     * Increases the capacity of this stack by 2 each time {@code size == capacity}.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        this.capacity *= 2;
        T[] temp = (T[]) new Object[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, size);
        this.data = temp;
    }

    /**
     * Returns an iterator over the elements in this deque.  The elements
     * will be ordered from the last to the first (LIFO)  This is the same
     * as elements being  peeked {@link #peek} or popped (via successive calls to {@link #pop}).
     *
     * @return an iterator over the elements in this stack
     */
    @Override
    public Iterator<T> iterator() {
        return new CustomStackIterator();
    }

    /**
     * Helper class which implements the logic of {@link #iterator}
     */
    private class CustomStackIterator implements Iterator<T> {
        /**
         * Used to set boundaries, and find the current element
         */
        int index = 0;

        /**
         * Uses {@code iterableSize} instead of {@code size} to ensure that even after iterating over the stack, we can still access the elements
         */
        int iterableSize = size;

        /**
         * checks if there are still elements present in the stack
         */
        @Override
        public boolean hasNext() {
            return iterableSize - 1 >= index;
        }

        /**
         * @return the next element of the stack
         */
        @Override
        public T next() {
            return data[--iterableSize];
        }
    }
}
