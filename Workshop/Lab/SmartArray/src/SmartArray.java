import java.util.Collection;

public class SmartArray {
    private static final int DEFAULT_CAPACITY = 4;
    private static final int DEFAULT_SIZE = 0;


    private int[] data;
    private int size; //? Holds the real size of the array
    private int capacity; //? Holds the whole size of the array

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
