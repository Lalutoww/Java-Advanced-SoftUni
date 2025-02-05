import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        Map<String, String> emails = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String name = input;
            String email = sc.nextLine();

            if (!email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("uk") && !email.toLowerCase().endsWith("com")) {
                emails.put(name, email);
            }

            input = sc.nextLine();
        }

        emails.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
