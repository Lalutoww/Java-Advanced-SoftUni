import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (number == 0) {
            System.out.println(0);
            return;
        }

        while (number != 0) {
            int leftOver = number % 2;
            binary.push(leftOver);
            number /= 2;
        }

        binary.forEach(System.out::print);
    }
}
