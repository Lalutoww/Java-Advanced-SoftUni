import java.util.*;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = new ArrayList<>(Arrays.stream(sc.nextLine().split("\\s+")).toList());
        Set<String> filters = new HashSet<>();
        String command = sc.nextLine();

        while (!command.equals("Party!")) {
            filters.add(command);
            command = sc.nextLine();
        }

        filters.forEach(filter -> {
            String currentCommand = filter.split("\\s+")[0];
            Predicate<String> correctFilter = getPredicate(filter);

            switch (currentCommand) {
                case "Remove" -> guests.removeIf(correctFilter);
                case "Double" -> guests.addAll(guests.stream().filter(correctFilter).toList());
            }
        });


        Collections.sort(guests);
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", String.join(", ", guests));
        }
    }

    private static Predicate<String> getPredicate(String filter) {
        String type = filter.split("\\s+")[1];
        String data = filter.split("\\s+")[2];

        return switch (type) {
            case "StartsWith" -> s -> s.startsWith(data);
            case "EndsWith" -> s -> s.endsWith(data);
            case "Length" -> s -> s.length() == Integer.parseInt(data);
            default -> throw new IllegalArgumentException("Unknown condition " + filter);
        };
    }
}
