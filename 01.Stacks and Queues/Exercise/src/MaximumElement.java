import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(sc.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            int[] currentCommandData = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int command = currentCommandData[0];
            switch (command) {
                case 1 -> stack.push(currentCommandData[1]);
                case 2 -> stack.pop();
                case 3 -> System.out.println(Collections.max(stack));
            }
        }
    }
}
