import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {
            String line = br.readLine();

            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
