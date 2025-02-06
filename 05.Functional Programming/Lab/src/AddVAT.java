import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnaryOperator<Double> addVAT = value -> value * 1.2;
        String input = sc.nextLine();

        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(",\\s+")).map(Double::parseDouble).map(addVAT).forEach(x -> System.out.printf("%.2f%n", x));
    }
}
