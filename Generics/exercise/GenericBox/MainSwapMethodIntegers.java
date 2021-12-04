package Generics.exercise.GenericBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainSwapMethodIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            Box box = new Box(number);
            boxes.add(box);
        }
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        SwapMethodStrings.swapStrings(boxes, firstIndex, secondIndex);
        for (int i = 0; i < boxes.size(); i++) {
            System.out.println(boxes.get(i));
        }
    }
}
