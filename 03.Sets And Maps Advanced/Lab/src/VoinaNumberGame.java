import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> playerOne = new LinkedHashSet<>();
        int[] first20Numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int number : first20Numbers) {
            playerOne.add(number);
        }

        Set<Integer> playerTwo = new LinkedHashSet<>();
        int[] second20Numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int number : second20Numbers) {
            playerTwo.add(number);
        }


        for (int i = 0; i < 50; i++) {
            int firstNumber = playerOne.iterator().next();
            int secondNumber = playerTwo.iterator().next();

            playerOne.remove(firstNumber);
            playerTwo.remove(secondNumber);

            if (firstNumber > secondNumber) {
                playerOne.addAll(List.of(firstNumber, secondNumber));
            } else if (secondNumber > firstNumber) {
                playerTwo.addAll(List.of(firstNumber, secondNumber));
            }

            if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                break;
            }
        }

        if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerTwo.size() > playerOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
