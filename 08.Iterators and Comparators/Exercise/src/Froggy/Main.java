package Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(",\\s*"))
                .map(Integer::parseInt)
                .toList();

        Lake lake = new Lake(numbers);

        Iterator<Integer> frogIterator = lake.iterator();
        List<Integer> frogNumbers = new ArrayList<>();
        List<Integer> otherNumbers = new ArrayList<>();

        while (frogIterator.hasNext()) {
            frogNumbers.add(frogIterator.next());
            if (frogIterator.hasNext()) {
                otherNumbers.add(frogIterator.next());
            }
        }

        String endCommand = sc.nextLine();
        if (endCommand.equals("END")) {
            frogNumbers.addAll(frogNumbers.size(), otherNumbers);
            System.out.println(String.join(", ", frogNumbers.stream().map(String::valueOf).toList()));
        }
    }
}
