import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (String currentSymbol : input) {
            if (currentSymbol.chars().allMatch(Character::isLetterOrDigit)) {
                output.append(currentSymbol);
                output.append(" ");
            } else if (currentSymbol.equals("(")) {
                stack.push(currentSymbol);
            } else if (currentSymbol.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.append(stack.pop());
                    output.append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getOperatorPriority(currentSymbol) <= getOperatorPriority(stack.peek()) && isOperator(currentSymbol)) {
                    output.append(stack.pop());
                    output.append(" ");
                }

                stack.push(currentSymbol);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
            output.append(" ");
        }

        System.out.println(output.toString().trim());
    }

    private static boolean isOperator(String currentSymbol) {
        return currentSymbol.equals("+") || currentSymbol.equals("-") || currentSymbol.equals("/") || currentSymbol.equals("*");
    }

    private static int getOperatorPriority(String currentSymbol) {

        return switch (currentSymbol) {
            case "+", "-" -> 1;
            case "/", "*" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }
}
