import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) {
        String inPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/input.txt";
        String outPath = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/03.CopyBytesOutput.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            int characterAscii = br.read();

            while (characterAscii != -1) {
                if (characterAscii == 32 || characterAscii == 10) {
                    writer.write(characterAscii);
                } else {
                    String digits = String.valueOf(characterAscii);
                    for (int i = 0; i < digits.length(); i++) {
                        writer.write(digits.charAt(i));
                    }
                }

                characterAscii = br.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
