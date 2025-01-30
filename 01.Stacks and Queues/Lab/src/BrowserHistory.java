import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();


        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (stack.isEmpty() || stack.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(command);
                System.out.println(command);
            }
            command = sc.nextLine();
        }
    }
}
