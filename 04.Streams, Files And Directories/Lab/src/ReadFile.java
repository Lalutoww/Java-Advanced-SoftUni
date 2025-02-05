import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/input.txt";

        try (FileInputStream in = new FileInputStream(path)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = in.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
