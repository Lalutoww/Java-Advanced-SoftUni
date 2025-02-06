import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerBound = sc.nextInt();
        int upperBound = sc.nextInt();
        String command = sc.next();

        List<Integer> numbers = new ArrayList<>();
        for (int i = lowerBound; i <= upperBound; i++) {
            numbers.add(i);
        }

        Predicate<Integer> evenOrOddPredicate = x -> {
            if (command.equals("even")) {
                return x % 2 == 0;
            }
            return x % 2 != 0;
        };
        numbers.stream().filter(evenOrOddPredicate).forEach(x -> System.out.print(x + " "));
    }
}
