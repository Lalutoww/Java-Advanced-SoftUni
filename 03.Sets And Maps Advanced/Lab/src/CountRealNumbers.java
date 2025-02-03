import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numberCounter = new LinkedHashMap<>();
        for (double number : numbers) {
            if (!numberCounter.containsKey(number)) {
                numberCounter.put(number, 1);
            } else {
                numberCounter.put(number, numberCounter.get(number) + 1);
            }
        }

        numberCounter.forEach((k,v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}
