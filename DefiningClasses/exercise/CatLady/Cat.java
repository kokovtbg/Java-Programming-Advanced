package DefiningClasses.exercise.CatLady;

public class Cat {
    private String breed;
    private String name;
    private double characteristic;

    public Cat(String breed, String name, double characteristic) {
        this.breed = breed;
        this.name = name;
        this.characteristic = characteristic;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, this.name, this.characteristic);
    }
}
