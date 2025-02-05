import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        //!THE TASK REQUIRES USING LONG, NOT INT!
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesTotalPopulation = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).putIfAbsent(city, population);
            countriesTotalPopulation.putIfAbsent(country, 0L);
            countriesTotalPopulation.put(country, countriesTotalPopulation.get(country) + countries.get(country).get(city));

            input = sc.nextLine();
        }

        countriesTotalPopulation.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach((entry) -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());
                    countries.get(entry.getKey()).entrySet()
                            .stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach((e) -> System.out.printf("=>%s: %d%n", e.getKey(), e.getValue()));
                });
    }
}
