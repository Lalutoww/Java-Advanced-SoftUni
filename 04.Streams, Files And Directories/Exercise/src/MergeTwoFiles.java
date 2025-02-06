import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String inPathOne = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/inputOne.txt";
        String inPathTwo = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/inputTwo.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/merged.txt";

        try (BufferedReader inputOne = new BufferedReader(new FileReader(inPathOne)); BufferedReader inputTwo = new BufferedReader(new FileReader(inPathTwo)); PrintWriter writer = new PrintWriter(outPath)) {
            writeInput(inputOne, writer);
            writeInput(inputTwo, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInput(BufferedReader inputOne, PrintWriter writer) throws IOException {
        String line = inputOne.readLine();
        while (line != null) {
            writer.println(line);
            line = inputOne.readLine();
        }
    }
}
