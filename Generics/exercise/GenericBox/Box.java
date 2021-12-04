package Generics.exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private T line;

    public Box(T line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line.getClass().toString().substring(line.getClass().toString().indexOf(" ") + 1) + ": " + line;
    }
    List<String> list = new ArrayList<>();
}
