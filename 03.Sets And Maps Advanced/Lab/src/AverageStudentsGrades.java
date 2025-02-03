import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] currentStudent = sc.nextLine().split("\\s+");
            String name = currentStudent[0];
            double grade = Double.parseDouble(currentStudent[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }

            students.get(name).add(grade);
        }

        //!SOFTUNI JUDGE TEST 8 DOESN'T PASS WHEN USING STREAM (don't know why)
        //?that's why this solution is using a for-loop to find the average
        students.forEach((key, value) -> {
            double sum = 0;
            for (int i = 0; i < value.size(); i++) {
                sum += value.get(i);
            }
            double avgSum = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(x -> System.out.printf("%.2f ", x));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });
    }
}
