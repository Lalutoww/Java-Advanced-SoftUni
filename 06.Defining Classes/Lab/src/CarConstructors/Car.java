package CarConstructors;

public class Car {
    private String make;
    private String model;
    private int horsePower;

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make) {
        this.make = make;
        this.model = "unknown";
        this.horsePower = -1;
    }


    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void getInfo() {
        System.out.printf("The car is: %s %s - %d HP.%n", make, model, horsePower);
    }
}
