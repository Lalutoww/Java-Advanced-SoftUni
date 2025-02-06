import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toList());
        String command = sc.nextLine();
        UnaryOperator<Integer> add = x -> x + 1;
        UnaryOperator<Integer> multiply = x -> x * 2;
        UnaryOperator<Integer> subtract = x -> x - 1;
        Consumer<Integer> print = x -> System.out.print(x + " ");
        while (!command.equals("end")) {
            switch (command) {
                case "add" -> numbers.replaceAll(add);
                case "multiply" -> numbers.replaceAll(multiply);
                case "subtract" -> numbers.replaceAll(subtract);
                case "print" -> numbers.forEach(print);
            }
            command = sc.nextLine();
        }
    }
}
