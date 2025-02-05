import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        Set<Character> punctuation = new HashSet<>(List.of(',', '.', '!', '?'));

        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/input.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/02.WriteToFileOutput.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            int character = br.read();
            while (character != -1) {
                if (!punctuation.contains((char) character)) {
                    writer.write(character);
                }
                character = br.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
