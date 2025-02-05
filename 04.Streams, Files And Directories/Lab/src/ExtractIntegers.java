import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/input.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/04.ExtractIntegersOutput.txt";

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(inPath))); PrintWriter writer = new PrintWriter(outPath)) {
            while (sc.hasNext()) {
                sc.next();
                if (sc.hasNextInt()) {
                    writer.println(sc.nextInt());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
