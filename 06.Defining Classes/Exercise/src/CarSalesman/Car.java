package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrintableWeight() {
        if (weight == -1) {
            return "n/a";
        }

        return String.valueOf(weight);
    }

    @Override
    public String toString() {
        return model + ":\n" +
                engine.getModel() + ":\n" +
                "Power: " + engine.getPower() + System.lineSeparator() +
                "Displacement: " + engine.getPrintableDisplacement() + System.lineSeparator() +
                "Efficiency: " + engine.getEfficiency() + System.lineSeparator() +
                "Weight: " + getPrintableWeight() + System.lineSeparator() +
                "Color: " + color;
    }
}
