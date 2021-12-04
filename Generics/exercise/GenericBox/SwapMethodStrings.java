package Generics.exercise.GenericBox;

import Generics.exercise.GenericBox.Box;

import java.util.List;

public class SwapMethodStrings {

    public static void swapStrings(List<Box> boxes, int firstIndex, int secondIndex) {
        Box box1 = boxes.get(firstIndex);
        Box box2 = boxes.get(secondIndex);
        Box box3 = box1;
        boxes.set(firstIndex, box2);
        boxes.set(secondIndex, box3);
    }
}
