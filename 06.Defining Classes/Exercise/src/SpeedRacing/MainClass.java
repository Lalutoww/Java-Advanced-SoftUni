package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carData = sc.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCost = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }

        String command = sc.nextLine();

        while (!command.equals("End")) {
            String carModel = command.split("\\s+")[1];
            double kilometers = Double.parseDouble(command.split("\\s+")[2]);

            if (cars.containsKey(carModel)) {
                cars.get(carModel).driveCar(kilometers);
            }

            command = sc.nextLine();
        }

        cars.forEach((key, value) -> System.out.println(value));
    }
}
