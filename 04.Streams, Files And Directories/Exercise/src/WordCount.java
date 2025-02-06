import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/text.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/results.txt";
        String wordsFilePath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/words.txt";

        try (BufferedReader wordsBr = new BufferedReader(new FileReader(wordsFilePath)); BufferedReader br = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            Map<String, Integer> wordsCount = new LinkedHashMap<>();
            String[] words = wordsBr.readLine().split("\\s+");

            for (String word : words) {
                wordsCount.put(word, 0);
            }

            String line = br.readLine();
            while (line != null) {
                for (String word : line.split("\\s+")) {
                    if (wordsCount.containsKey(word)) {
                        wordsCount.put(word, wordsCount.get(word) + 1);
                    }
                }
                line = br.readLine();
            }
            wordsCount.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(x -> writer.println(x.getKey() + " - " + x.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
