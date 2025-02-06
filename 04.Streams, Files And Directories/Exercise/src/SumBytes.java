import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {
            String line = br.readLine();
            int sum = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = br.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
