import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            chemicalElements.addAll(List.of(input));
        }

        chemicalElements.forEach(e -> System.out.print(e + " "));
    }
}
