package RawData;

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
            Car car = getCar(carData, model, i);

            cars.put(model, car);
        }

        String command = sc.nextLine();

        switch (command) {
            case "fragile" ->
                    cars.entrySet().stream().filter(c -> c.getValue().getCargo().getType().equals("fragile") && c.getValue().isFragileCompatible()).forEach(c -> System.out.println(c.getKey()));
            case "flamable" -> //!TASK TYPO -> COMMAND IS "FLAMABLE"
                    cars.entrySet().stream().filter(c -> c.getValue().getCargo().getType().equals("flamable") && c.getValue().isFlammableCompatible()).forEach(c -> System.out.println(c.getKey()));
        }
    }

    private static Car getCar(String[] carData, String model, int i) {
        int engineSpeed = Integer.parseInt(carData[1]);
        int enginePower = Integer.parseInt(carData[2]);
        int cargoWeight = Integer.parseInt(carData[3]);
        String cargoType = carData[4];

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Car car = new Car(model, engine, cargo);

        for (int j = 5; j <= 8; j += 2) {
            double tirePressure = Double.parseDouble(carData[j]);
            int tireAge = Integer.parseInt(carData[j + 1]);
            Tire tire = new Tire(tirePressure, tireAge);
            car.addTire(tire);
        }
        return car;
    }
}
