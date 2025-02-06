import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/inputLineNumbers.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/output2.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            String line = br.readLine();
            int lineNumber = 1;
            while (line != null) {
                writer.println(lineNumber + ". " + line);
                lineNumber++;
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
