import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayDeque<String> calculator = new ArrayDeque<>();
        Collections.addAll(calculator, input);

        while (calculator.size() != 1) {
            int firstNumber = Integer.parseInt(calculator.pop());
            char operator = calculator.pop().charAt(0);
            int secondNumber = Integer.parseInt(calculator.pop());

            int sum = 0;
            switch (operator) {
                case '+' -> sum = firstNumber + secondNumber;
                case '-' -> sum = firstNumber - secondNumber;
            }

            calculator.push(String.valueOf(sum));
        }
        System.out.println(calculator.peek());
    }
}
