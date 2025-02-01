import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(sc.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandData = sc.nextLine().split(" ");
            String command = commandData[0];
            switch (command) {
                case "1" -> {
                    textStack.push(text.toString());
                    text.append(commandData[1]);
                }
                case "2" -> {
                    textStack.push(text.toString());
                    int elementsToErase = Integer.parseInt(commandData[1]);
                    text.delete(text.length() - elementsToErase, text.length());
                }
                case "3" -> System.out.println(text.charAt(Integer.parseInt(commandData[1]) - 1));
                case "4" -> {
                    if (!textStack.isEmpty()) {
                        text = new StringBuilder(textStack.pop());
                    }
                }
            }
        }

    }
}
