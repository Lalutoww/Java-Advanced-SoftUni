import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        Set<Character> punctuations = new HashSet<>(List.of('!', ',', '.', '?'));

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/input.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            String line = br.readLine();
            while (line != null) {
                for (char character : line.toCharArray()) {

                    if (vowels.contains(character)) {
                        vowelsCount++;
                    } else if (punctuations.contains(character)) {
                        punctuationCount++;
                    } else if (character != ' ') {
                        consonantsCount++;
                    }
                }

                line = br.readLine();
            }
            writer.println("Vowels: " + vowelsCount);
            writer.println("Other symbols: " + consonantsCount);
            writer.println("Punctuation: " + punctuationCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
