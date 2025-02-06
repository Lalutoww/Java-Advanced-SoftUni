import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllCapitals {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line.toUpperCase());
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
