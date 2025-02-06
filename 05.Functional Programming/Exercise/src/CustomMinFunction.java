import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Must use Integer[] instead of int[] (problem requirement)
        Integer[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Function<Integer[], Integer> findMin = x -> {
            int min = Integer.MAX_VALUE;
            for (Integer integer : x) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        };

        System.out.println(findMin.apply(input));
    }
}
