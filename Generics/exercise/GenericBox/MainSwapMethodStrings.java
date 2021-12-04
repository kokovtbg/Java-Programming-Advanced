package Generics.exercise.GenericBox;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainSwapMethodStrings {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        int n = Integer.parseInt(scan.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            Box box = new Box(line);
            boxes.add(box);
        }
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        SwapMethodStrings.swapStrings(boxes, firstIndex, secondIndex);
        for (int i = 0; i < boxes.size(); i++) {
            writer.write(boxes.get(i) + "");
            writer.newLine();
        }
        writer.flush();
    }
}
