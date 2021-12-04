package Generics.exercise.Threeuple1;

public class Threeuple<T, N, P> {
    private T firstElement;
    private N secondElement;
    private P thirdElement;

    public Threeuple(T firstElement, N secondElement, P thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstElement, this.secondElement, this.thirdElement);
    }
}
