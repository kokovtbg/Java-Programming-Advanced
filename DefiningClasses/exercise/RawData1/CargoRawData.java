package DefiningClasses.exercise.RawData1;

public class CargoRawData {
    private String model;
    private int cargoWeight;
    private String cargoType;

    public CargoRawData(String model, int cargoWeight, String cargoType) {
        this.model = model;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getModel() {
        return model;
    }

    public String getCargoType() {
        return cargoType;
    }
}
