import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] childNames = sc.nextLine().split(" ");
        PriorityQueue<String> children = new PriorityQueue<>();
        Collections.addAll(children, childNames);
        int removeCount = Integer.parseInt(sc.nextLine());
        int cycles = 1;


        while (children.size() != 1) {
            for (int i = 1; i < removeCount; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            if (isPrime(cycles)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }

            cycles++;
        }
        System.out.println("Last is " + children.peek());
    }

    private static boolean isPrime(int cycles) {
        if (cycles <= 1) {
            return false;
        }

        for (int i = 2; i < cycles; i++) {
            if (cycles % i == 0) {
                return false;
            }
        }

        return true;
    }
}
