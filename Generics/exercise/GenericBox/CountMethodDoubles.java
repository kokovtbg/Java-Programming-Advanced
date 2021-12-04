package Generics.exercise.GenericBox;

import java.util.List;

public class CountMethodDoubles<T extends Comparable<T>> {

    public int countDoubles(List<Box> boxes, T number) {
        int count = 0;
        for (int i = 0; i < boxes.size(); i++) {
            if (Double.compare(Double.parseDouble(boxes.get(i).toString().split(" ")[1]), Double.parseDouble(number.toString().split(" ")[1])) > 0) {
                count++;
            }
        }
        return count;
    }
}
