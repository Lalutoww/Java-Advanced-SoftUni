import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            phonebook.put(name, phoneNumber);

            input = sc.nextLine();
        }

        String nameToSearch = sc.nextLine();

        while (!nameToSearch.equals("stop")) {
            if (phonebook.containsKey(nameToSearch)) {
                System.out.println(nameToSearch + " -> " + phonebook.get(nameToSearch));
            } else {
                System.out.println("Contact " + nameToSearch + " does not exist.");
            }

            nameToSearch = sc.nextLine();
        }
    }
}
