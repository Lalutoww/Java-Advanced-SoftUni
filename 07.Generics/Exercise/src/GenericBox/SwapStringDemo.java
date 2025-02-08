package GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwapStringDemo {
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

        Box.swapElements(boxes, indexOne, indexTwo);
        boxes.forEach(System.out::println);

    }
}
