package DefiningClasses.exercise.SpeedRacing2;

public class SpeedRacing {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public SpeedRacing(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

    public double carCanMove(double fuelAmount, double fuelCost, int distanceToBeTraveled) {
        if (fuelAmount >= fuelCost * distanceToBeTraveled) {
            setDistanceTraveled(getDistanceTraveled() + distanceToBeTraveled);
            return fuelAmount - (fuelCost * distanceToBeTraveled);
        }
        System.out.println("Insufficient fuel for the drive");
        return fuelAmount;
    }
}
