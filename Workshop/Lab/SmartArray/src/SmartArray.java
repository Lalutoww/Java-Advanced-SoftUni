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
     */
    public void add(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.data[size] = element;
        size++;
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
        System.arraycopy(this.data, 0, temp, 0, data.length);
        data = temp;
    }
}
