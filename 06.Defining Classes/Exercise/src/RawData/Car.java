package RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new ArrayList<>();
    }

    public void addTire(Tire tire) {
        this.tires.add(tire);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public boolean isFragileCompatible() {
        return tires.stream().anyMatch(t -> t.getPressure() < 1);
    }

    public boolean isFlammableCompatible() {
        return engine.getPower() > 250;
    }

    @Override
    public String toString() {
        return model;
    }
}
