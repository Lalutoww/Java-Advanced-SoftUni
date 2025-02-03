import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String guest = sc.nextLine();

        Set<String> invitedGuests = new TreeSet<>();
        while (!guest.equals("PARTY")) {
            invitedGuests.add(guest);

            guest = sc.nextLine();
        }

        String comingGuest = sc.nextLine();
        while (!comingGuest.equals("END")) {
            invitedGuests.remove(comingGuest);

            comingGuest = sc.nextLine();
        }

        System.out.println(invitedGuests.size());
        invitedGuests.forEach(System.out::println);
    }
}
