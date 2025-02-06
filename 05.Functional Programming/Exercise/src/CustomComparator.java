import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<Integer> evenComparator = (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) return -1;
            else if (a % 2 != 0 && b % 2 == 0) return 1;

            return a.compareTo(b);
        };
        Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).sorted(evenComparator).forEach(x -> System.out.print(x + " "));
    }
}
