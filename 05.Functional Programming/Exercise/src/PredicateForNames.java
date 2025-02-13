import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int requiredLength = Integer.parseInt(sc.nextLine());

        Predicate<String> namePredicate = x -> x.length() <= requiredLength;

        Arrays.stream(sc.nextLine().split("\\s+")).filter(namePredicate).forEach(System.out::println);
    }
}
