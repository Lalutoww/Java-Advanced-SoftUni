package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = sc.nextLine().split("\\s+");
            String make = carData[0];
            String model = carData[1];
            int horsePower = Integer.parseInt(carData[2]);

            Car car = new Car();
            car.setMake(make);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carList.add(car);
        }

        carList.forEach(Car::getInfo);
    }
}
