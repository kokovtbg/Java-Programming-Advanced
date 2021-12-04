package Generics.exercise.GenericBox;

public class BoxOfInteger<T> {
    private T number;

    public BoxOfInteger(T number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number.getClass().toString().substring(number.getClass().toString().indexOf(" ") + 1) + ": " + number;
    }
}
