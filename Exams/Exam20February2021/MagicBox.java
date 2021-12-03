package Exams.Exam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers1 = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers2 = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> box1 = new ArrayDeque<>();
        for (int i = 0; i < numbers1.length; i++) {
            box1.offer(numbers1[i]);
        }
        ArrayDeque<Integer> box2 = new ArrayDeque<>();
        for (int i = 0; i < numbers2.length; i++) {
            box2.push(numbers2[i]);
        }
        int sum = 0;
        while (!box1.isEmpty() && !box2.isEmpty()) {
            if ((box1.peek() + box2.peek()) % 2 == 0) {
                sum += box1.poll() + box2.pop();
            } else {
                box1.offer(box2.pop());
            }
        }
        if (box1.isEmpty()) {
            System.out.printf("First magic box is empty.%n");
        } else {
            System.out.printf("Second magic box is empty.%n");
        }
        if (sum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sum);
        }
    }
}
