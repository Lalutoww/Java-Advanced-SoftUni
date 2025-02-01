import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbersToPush = sc.nextInt();
        int numbersToPop = sc.nextInt();
        int numberToCheck = sc.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>(numbersToPush);
        for (int i = 0; i < numbersToPush; i++) {
            stack.push(sc.nextInt());
        }

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (stack.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stack));
        }

    }
}
