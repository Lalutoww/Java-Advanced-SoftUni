import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] childNames = sc.nextLine().split(" ");
        int removeCount = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, childNames);

        while (children.size() != 1) {
            for (int i = 1; i < removeCount; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            System.out.println("Removed " + children.poll());
        }

        System.out.println("Last is " + children.peek());
    }
}
