package ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils<T> {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        checkIfEmpty(list);
        return Collections.min(list);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        checkIfEmpty(list);
        return Collections.max(list);
    }

    private static <T> void checkIfEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
