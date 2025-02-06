import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) {
        Path folder = Paths.get("/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Exercise/src/resources/GetFolderSize");
        long size = 0;
        try {
            size = Files.walk(folder)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Folder size: %d", size);
    }
}
