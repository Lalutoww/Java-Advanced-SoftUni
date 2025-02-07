package Google;

public class Car {

    private String car;
    private String speed;

    public Car(String car, String speed) {
        this.car = car;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return car + " " + speed;
    }
}
