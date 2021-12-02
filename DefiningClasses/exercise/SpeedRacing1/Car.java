package DefiningClasses.exercise.SpeedRacing1;

public class Car {
    private String model;
    private double fuelAmount;
    private double consumption;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = fuelCost;
        this.distanceTraveled = 0;
    }

    public boolean drive(double kilometersToDrive) {
        double fuelRequired = kilometersToDrive * consumption;
        if (fuelRequired > this.fuelAmount) {
            return false;
        } else {
            this.fuelAmount -= fuelRequired;
            this.distanceTraveled += kilometersToDrive;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
