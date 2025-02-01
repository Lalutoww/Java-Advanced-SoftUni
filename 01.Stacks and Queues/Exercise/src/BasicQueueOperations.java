import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbersToPush = sc.nextInt();
        int numbersToPop = sc.nextInt();
        int numberToCheck = sc.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>(numbersToPush);
        for (int i = 0; i < numbersToPush; i++) {
            queue.offer(sc.nextInt());
        }

        for (int i = 0; i < numbersToPop; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (queue.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
