import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double[] grades = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            students.putIfAbsent(name, grades);
        }

        students.forEach((k, v) -> {
            System.out.print(k + " is graduated with ");
            double sum = 0;
            for (double number : v) {
                sum += number;
            }
            double avg = sum / v.length;
            System.out.print(avg + System.lineSeparator());
        });
    }
}
