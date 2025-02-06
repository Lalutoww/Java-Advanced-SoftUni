import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split(",\\s+")).map(Integer::parseInt).toList();
        String evenInput = input.stream()
                .filter(x -> x % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(evenInput);

        String sortedInput = input.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedInput);

    }
}
