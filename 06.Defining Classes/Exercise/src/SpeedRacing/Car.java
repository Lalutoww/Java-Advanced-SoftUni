package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKM;
    private double distanceTravelled;


    public Car(String model, double fuelAmount, double fuelCostPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKM = fuelCostPerKM;
        this.distanceTravelled = 0;
    }

    public void driveCar(double kilometers) {
        double maxCarDistance = fuelAmount / fuelCostPerKM;
        if (kilometers > maxCarDistance) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            fuelAmount -= kilometers * fuelCostPerKM;
            distanceTravelled += kilometers;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", model, fuelAmount, distanceTravelled);
    }
}
