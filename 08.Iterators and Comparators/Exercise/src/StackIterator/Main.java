package StackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomStack stack = new CustomStack();

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String command = input.split("\\s+", 2)[0];

            switch (command) {
                case "Push" -> {
                    List<Integer> elements = Arrays.stream(input.split("\\s+", 2)[1]
                                    .split(",\\s*"))
                            .map(Integer::parseInt)
                            .toList();
                    stack.push(elements);
                }
                case "Pop" -> stack.pop();
            }

            input = sc.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);

    }
}
