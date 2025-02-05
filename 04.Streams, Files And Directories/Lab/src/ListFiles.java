import java.io.File;
import java.util.ArrayDeque;

public class ListFiles {
    public static void main(String[] args) {
        File mainFolder = new File("/Users/lalutoww/Documents/SoftUni/Java-Advanced/04.Streams, Files And Directories/Lab/src/resources/Files-and-Streams");

        ArrayDeque<File> folders = new ArrayDeque<>();
        folders.offer(mainFolder);

        int folderCount = 0;
        while (!folders.isEmpty()) {
            File currentFolder = folders.poll();
            File[] nestedFiles = currentFolder.listFiles();
            if (nestedFiles != null) {
                for (File file : nestedFiles) {
                    if (file.isDirectory()) {
                        folders.offer(file);
                    }
                }
            }
            folderCount++;
            System.out.println(currentFolder.getName());
        }
        System.out.printf("%d folders%n", folderCount);
    }
}
