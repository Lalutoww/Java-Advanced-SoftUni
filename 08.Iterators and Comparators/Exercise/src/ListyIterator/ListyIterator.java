package ListyIterator;

import java.util.List;

public class ListyIterator<T> {
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
}
