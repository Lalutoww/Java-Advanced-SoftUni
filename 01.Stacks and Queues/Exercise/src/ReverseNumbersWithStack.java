import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        ArrayDeque<String> numbersStack = new ArrayDeque<>();

        for (String number : numbers) {
            numbersStack.push(number);
        }

        numbersStack.forEach(n -> System.out.print(n + " "));
    }
}
