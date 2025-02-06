import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).toList();

        Function<List<Integer>, Integer> findSmallest = list -> {
            int min = Integer.MAX_VALUE;
            for (Integer currentNum : list) {
                if (currentNum < min) {
                    min = currentNum;
                }
            }
            return list.lastIndexOf(min);
        };

        System.out.println(findSmallest.apply(numbers));
    }
}
