import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            symbolsCount.putIfAbsent(currentCharacter, 0);
            symbolsCount.put(currentCharacter, symbolsCount.get(currentCharacter) + 1);
        }

        symbolsCount.forEach((k, v) -> System.out.printf("%s: %d time/s%n", k, v));
    }
}
