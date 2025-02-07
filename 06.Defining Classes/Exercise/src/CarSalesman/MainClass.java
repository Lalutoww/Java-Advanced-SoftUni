package CarSalesman;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] engineData = sc.nextLine().split("\\s+");
            String name = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            Engine engine = new Engine(name, power);

            if (engineData.length == 3) {
                if (!isNumber(engineData[2])) {
                    String efficiency = engineData[2];
                    engine.setEfficiency(efficiency);
                } else {
                    int displacement = Integer.parseInt(engineData[2]);
                    engine.setDisplacement(displacement);
                }
            } else if (engineData.length == 4) {
                int displacement = Integer.parseInt(engineData[2]);
                String efficiency = engineData[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }

            engines.put(name, engine);
        }

        int m = Integer.parseInt(sc.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] carData = sc.nextLine().split("\\s+");
            String model = carData[0];
            Engine engine = engines.get(carData[1]);
            Car car = new Car(model, engine);

            if (carData.length == 3) {
                if (!isNumber(carData[2])) {
                    String color = carData[2];
                    car.setColor(color);
                } else {
                    int weight = Integer.parseInt(carData[2]);
                    car.setWeight(weight);
                }
            } else if (carData.length == 4) {
                int weight = Integer.parseInt(carData[2]);
                String color = carData[3];
                car.setWeight(weight);
                car.setColor(color);
            }
            carList.add(car);
        }

        carList.forEach(System.out::println);
    }

    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
