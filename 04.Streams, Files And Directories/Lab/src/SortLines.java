import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/input.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/06.SortLinesOutput.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            List<String> lines = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }

            Collections.sort(lines);
            lines.forEach(writer::println);
            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
