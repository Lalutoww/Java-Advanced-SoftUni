package StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer> {
    private List<Integer> elements;

    public CustomStack() {
        this.elements = new ArrayList<>();
    }

    public void push(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            elements.addAll(numbers);
        }
    }

    public void pop() {
        if (elements.isEmpty()) {
            System.out.println("No elements");
            return;
        }
        elements.removeLast();
    }


    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Integer> {
        private int index = elements.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            return elements.get(index--);
        }
    }
}
