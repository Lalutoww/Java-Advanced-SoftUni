import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, ArrayList<String>>> worldMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            worldMap.putIfAbsent(continent, new LinkedHashMap<>());
            worldMap.get(continent).putIfAbsent(country, new ArrayList<>());
            worldMap.get(continent).get(country).add(city);
        }

        worldMap.forEach((k, v) -> {
            System.out.printf("%s:%n", k);
            v.forEach((country, cities) -> {
                System.out.printf("  %s -> %s%n", country, String.join(", ", cities));
            });
        });
    }
}
