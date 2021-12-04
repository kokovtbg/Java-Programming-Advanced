package Generics.exercise.GenericBox;

import java.util.List;

public class CountMethodStrings<T extends Comparable<T>> {

    public int countStrings(List<Box> boxes, T text) {
        int count = 0;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).toString().compareTo(text.toString()) > 0) {
                count++;
            }
        }
        return count;
    }
}
