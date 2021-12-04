package Generics.exercise.Tuple1;

public class Tuple<T, N> {
    private T item1;
    private N item2;

    public Tuple(T item1, N item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1, this.item2);
    }
}
