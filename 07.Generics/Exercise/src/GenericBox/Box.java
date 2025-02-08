package GenericBox;

import java.util.Collections;
import java.util.List;

public class Box<T> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    public static <T> void swapElements(List<T> list, int indexOne, int indexTwo) {
        if (indexOne >= 0 && indexOne < indexTwo && indexTwo < list.size()) {
            Collections.swap(list, indexOne, indexTwo);
        } else {
            throw new IndexOutOfBoundsException("Please enter valid indices");
        }
    }

    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }
}
