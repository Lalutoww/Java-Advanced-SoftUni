import java.util.function.Consumer;

public class SmartArray {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * Default initial size.
     */
    private static final int DEFAULT_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    /**
     * Constructs a SmartArray containing the elements of the specified
     * with a default capacity of 4 and default size of 0
     * <p>
     * This SmartArray is based on a normal Array
     */
    public SmartArray() {
        this.data = new int[DEFAULT_CAPACITY];
        this.size = DEFAULT_SIZE;
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @throws IndexOutOfBoundsException – if the index is out of range {@code (index < 0 || index >= size())}
     */
    public void add(int element) {
        checkIfNeedToResize();
        this.data[size] = element;
        size++;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range {@code (index < 0 || index >= size())}
     */
    public void add(int index, int element) {
        this.checkIndex(index);

        if (index == this.size - 1) {
            int oldElement = this.data[this.size - 1];
            this.add(oldElement);
            this.data[this.size - 2] = element;
        } else {
            checkIfNeedToResize();
            this.size++;
            this.shiftRight(index);
            this.data[index] = element;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException – if the index is out of range {@code (index < 0 || index >= size())}
     */
    public int get(int index) {
        this.checkIndex(index);

        return this.data[index];
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException – if the index is out of range {@code (index < 0 || index >= size())}
     */
    public int remove(int index) {
        this.checkIndex(index);
        int removedElement = this.get(index);
        shiftLeft(index);
        size--;

        if (this.size <= this.capacity / 4) {
            this.shrink();
        }
        return removedElement;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element, otherwise {@code false}
     */
    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void checkIfNeedToResize() {
        if (this.size == this.capacity) {
            this.resize();
        }
    }

    /**
     * The shift method uses a loop, which moves all of the elements to the left, starting from a given index.
     */
    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    /**
     * The shift method uses a loop, which moves all of the elements to the right, starting from a given index.
     */
    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    /**
     * Decrease the size and check if it is 4 times smaller than the capacity. Probably it is but is not necessarily. If its
     * smaller, a good idea is to shrink our array, so we can free some memory. Our SmartArray will keep only integers,
     * which makes it pretty easy with the memory consumption. However if we had to store complex objects, which
     * would have taken a lot more memory, we would rather think about shrinking it anyway.
     */

    private void shrink() {
        this.capacity /= 2;
        int[] temp = new int[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, this.size);
        this.data = temp;
    }

    /**
     * Checks if the {@code index} is within the bounds of the range from
     * {@code 0} (inclusive) to {@code length} (exclusive).
     *
     * <p>The {@code index} is defined to be out of bounds if any of the
     * following inequalities is true:
     * <ul>
     *  <li>{@code index < 0}</li>
     *  <li>{@code index >= length}</li>
     * </ul>
     *
     * @param index the index
     * @throws IndexOutOfBoundsException if the {@code index} is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d is out of bounds.", index);
            throw new IndexOutOfBoundsException(message);
        }
    }

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     */
    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, size);
        data = temp;
    }
}
