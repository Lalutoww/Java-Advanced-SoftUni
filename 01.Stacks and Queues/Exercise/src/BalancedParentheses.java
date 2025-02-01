import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayDeque<Character> openParenthesesStack = new ArrayDeque<>();
        ArrayDeque<Character> closingParenthesesQueue = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            if (currentCharacter == '{' || currentCharacter == '(' || currentCharacter == '[') {
                openParenthesesStack.push(currentCharacter);
            } else {
                closingParenthesesQueue.offer(currentCharacter);
            }
        }

        boolean areBalanced = false;
        if (openParenthesesStack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        if (openParenthesesStack.size() != closingParenthesesQueue.size()) {
            System.out.println("NO");
            return;
        } else {
            for (int i = 0; i < openParenthesesStack.size(); i++) {
                char openingBracket = openParenthesesStack.pop();
                char closingBracket = closingParenthesesQueue.poll();
                if (openingBracket == '(' && closingBracket == ')') {
                    areBalanced = true;
                } else if (openingBracket == '{' && closingBracket == '}') {
                    areBalanced = true;
                } else if (openingBracket == '[' && closingBracket == ']') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                }
            }

        }

        System.out.println(areBalanced ? "YES" : "NO");
    }
}
