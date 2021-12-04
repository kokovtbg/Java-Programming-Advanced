package Generics.exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCountMethodStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            Box box = new Box(line);
            boxes.add(box);
        }
        String text = scan.nextLine();
        Box box = new Box(text);
        CountMethodStrings countMethodStrings = new CountMethodStrings();
        System.out.println(countMethodStrings.countStrings(boxes, box.toString()));
    }
}
