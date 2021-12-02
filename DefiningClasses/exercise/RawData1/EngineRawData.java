package DefiningClasses.exercise.RawData1;

public class EngineRawData {
    private String model;
    private int engineSpeed;
    private int enginePower;

    public EngineRawData(String model, int engineSpeed, int enginePower) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }
}
