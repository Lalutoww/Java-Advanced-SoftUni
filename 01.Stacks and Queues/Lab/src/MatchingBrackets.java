import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayDeque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            if (currentCharacter == '(') {
                indices.push(i);
            } else if (currentCharacter == ')') {
                int openingBracketIndex = indices.pop();
                System.out.println(input.substring(openingBracketIndex, i + 1));
            }
        }
    }
}
