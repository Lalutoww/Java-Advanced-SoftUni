import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",\\s+");

        System.out.println("Count = " + input.length);
        Function<String, Integer> parser = Integer::parseInt;
        List<Integer> numbers = Arrays.stream(input).map(parser).toList();
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " + sum);

    }
}
