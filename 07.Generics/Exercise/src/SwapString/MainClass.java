package SwapString;

import GenericBox.Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String element = sc.nextLine();
            Box<String> box = new Box<>(element);
            boxes.add(box);
        }

        int indexOne = sc.nextInt();
        int indexTwo = sc.nextInt();

        swapElements(boxes, indexOne, indexTwo);
        boxes.forEach(System.out::println);

    }

    private static <T> void swapElements(List<T> list, int indexOne, int indexTwo) {
        if (indexOne >= 0 && indexOne < indexTwo && indexTwo < list.size()) {
            Collections.swap(list, indexOne, indexTwo);
        } else {
            throw new IndexOutOfBoundsException("Please enter valid indices");
        }
    }
}
