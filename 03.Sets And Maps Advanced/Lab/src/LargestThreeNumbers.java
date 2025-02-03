import java.util.Arrays;
import java.util.Scanner;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbersInput = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).sorted((a, b) -> Integer.compare(b, a)).mapToInt(Integer::intValue).limit(3).toArray();

        for (int number : numbersInput) {
            System.out.print(number + " ");
        }
    }
}

