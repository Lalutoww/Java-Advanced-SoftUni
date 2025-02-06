import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] personData = sc.nextLine().split(",\\s+");
            people.put(personData[0], Integer.parseInt(personData[1]));
        }

        String condition = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        Predicate<Integer> conditionPredicate = (years) -> {
            if (condition.equals("older")) {
                return years >= age;
            }
            return years <= age;
        };


        Consumer<Map.Entry<String, Integer>> print = x -> {
            if (format.equals("name")) {
                System.out.println(x.getKey());
            } else if (format.equals("age")) {
                System.out.println(x.getValue());
            } else {
                System.out.printf("%s - %d%n", x.getKey(), x.getValue());
            }
        };
        people.entrySet().stream().filter(x -> conditionPredicate.test(x.getValue())).forEach(print);
    }
}
