package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<String> elements = Arrays.stream(sc.nextLine().split("\\s+")).skip(1).toList();
        ListyIterator<String> list = new ListyIterator<>(elements);

        String command = sc.nextLine();

        while (!command.equals("END")) {
            switch (command) {
                case "Move" -> System.out.println(list.move());
                case "Print" -> list.print();
                case "HasNext" -> System.out.println(list.hasNext());
                case "PrintAll" -> {
                    list.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                }
            }

            command = sc.nextLine();
        }
    }
}
