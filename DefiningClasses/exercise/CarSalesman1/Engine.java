package DefiningClasses.exercise.CarSalesman1;

public class Engine {
    private String model;
    private int power;

    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacementPrint;
        if (this.displacement == 0) {
            displacementPrint = "n/a";
        } else {
            displacementPrint = displacement + "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(model).append(":\n").append("Power: " + power + "\n").append("Displacement: " + displacementPrint + "\n").append("Efficiency: " + efficiency + "\n");
        return stringBuilder.toString();
    }
}
