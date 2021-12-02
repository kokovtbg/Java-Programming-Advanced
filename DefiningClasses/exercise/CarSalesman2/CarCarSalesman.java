package DefiningClasses.exercise.CarSalesman2;

public class CarCarSalesman {
    private String model;
    private String engine;
    private String weight;
    private String color;

    public CarCarSalesman(String model, String engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public CarCarSalesman(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
