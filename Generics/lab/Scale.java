package Generics.lab;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier () {
        if (left.toString().compareTo(right.toString()) > 0) {
            return left;
        } else if (left.toString().compareTo(right.toString()) < 0) {
            return right;
        } else {
            return null;
        }
    }
}
