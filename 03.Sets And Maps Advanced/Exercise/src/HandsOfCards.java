import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] personData = input.split(":\\s+");
            String name = personData[0];
            String[] drawnCards = personData[1].split(",\\s+");
            if (!players.containsKey(name)) {
                players.put(name, new LinkedHashSet<>(List.of(drawnCards)));
            } else {
                players.get(name).addAll(List.of(drawnCards));
            }

            input = sc.nextLine();
        }

        players.forEach((k, v) -> System.out.printf("%s: %d%n", k, calculatePoints(v)));
    }

    private static int calculatePoints(Set<String> v) {
        int totalPoints = 0;
        Iterator<String> card = v.iterator();
        for (int i = 0; i < v.size(); i++) {
            String currentCard = card.next();
            //?Can be swapped with a switch case, but that is easier to read
            Map<Character, Integer> cardsData = collectCardData();

            if (currentCard.startsWith("10")) {
                int cardType = cardsData.get(currentCard.charAt(2));
                totalPoints += 10 * cardType;
            } else {
                int cardPower = cardsData.get(currentCard.charAt(0));
                int cardType = cardsData.get(currentCard.charAt(1));

                totalPoints += cardPower * cardType;
            }
        }

        return totalPoints;
    }

    private static Map<Character, Integer> collectCardData() {
        return new HashMap<>() {{
            //?Puts the data immediately, instead of writing powers.put everytime
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('J', 11);
            put('Q', 12);
            put('K', 13);
            put('A', 14);
            put('S', 4);
            put('H', 3);
            put('D', 2);
            put('C', 1);
        }};
    }
}
