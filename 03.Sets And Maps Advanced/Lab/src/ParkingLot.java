import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();

        while (!command.equals("END")) {
            String[] commandData = command.split(",\\s+");
            String direction = commandData[0];
            String carNumber = commandData[1];

            switch (direction) {
                case "IN" -> carNumbers.add(carNumber);
                case "OUT" -> carNumbers.remove(carNumber);
            }
            command = sc.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            carNumbers.forEach(System.out::println);
        }
    }
}
