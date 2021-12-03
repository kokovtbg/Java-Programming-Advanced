package Exams.Exam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersLilies = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersRoses = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        for (int i = 0; i < numbersLilies.length; i++) {
            lilies.push(numbersLilies[i]);
        }
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        for (int i = 0; i < numbersRoses.length; i++) {
            roses.offer(numbersRoses[i]);
        }
        int flowers = 0;
        int wreaths = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            if (lilies.peek() + roses.peek() == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (lilies.peek() + roses.peek() > 15) {
                int numberToPush = lilies.pop() - 2;
                lilies.push(numberToPush);
            } else {
                flowers += lilies.pop() + roses.poll();
            }
        }
        wreaths += flowers / 15;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
