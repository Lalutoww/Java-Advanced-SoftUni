import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Predicate<String> upperCasePredicate = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCaseWords = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(upperCasePredicate).toList();

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);
    }
}
