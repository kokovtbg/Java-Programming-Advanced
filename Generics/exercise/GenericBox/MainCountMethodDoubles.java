package Generics.exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCountMethodDoubles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(scan.nextLine());
            Box box = new Box(number);
            boxes.add(box);
        }
        double number = Double.parseDouble(scan.nextLine());
        Box box = new Box(number);
        CountMethodDoubles countMethodDoubles = new CountMethodDoubles();
        System.out.println(countMethodDoubles.countDoubles(boxes, box.toString()));
    }
}
