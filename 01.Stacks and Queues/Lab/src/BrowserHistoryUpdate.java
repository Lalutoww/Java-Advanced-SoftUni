import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();


        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();


        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (stack.isEmpty() || stack.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stack.pop());
                    System.out.println(stack.peek());
                }
            } else if (command.equals("forward")) {
                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String forward = stackForward.pop();
                    System.out.println(forward);
                    stack.push(forward);
                }
            } else {
                stack.push(command);
                System.out.println(command);
                stackForward.clear();
            }
            command = sc.nextLine();
        }
    }
}

