package Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> elements;
    private int index;

    public ListyIterator(List<T> elements) {
        this.elements = elements;
        index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public void print() throws Exception {
        if (elements.isEmpty()) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(elements.get(index));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int indexIterator = 0;

            @Override
            public boolean hasNext() {
                return indexIterator < elements.size();
            }

            @Override
            public T next() {
                return elements.get(indexIterator++);
            }
        };
    }
}
