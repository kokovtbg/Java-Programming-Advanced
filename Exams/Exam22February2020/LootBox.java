package Exams.Exam22February2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersFirstBox = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersSecondBox = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        for (int i = 0; i < numbersFirstBox.length; i++) {
            firstBox.offer(numbersFirstBox[i]);
        }
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        for (int i = 0; i < numbersSecondBox.length; i++) {
            secondBox.push(numbersSecondBox[i]);
        }
        int sum = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            if ((firstBox.peek() + secondBox.peek()) % 2 == 0) {
                sum += firstBox.poll() + secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }
        if (firstBox.isEmpty()) {
            System.out.printf("First lootbox is empty%n");
        } else {
            System.out.printf("Second lootbox is empty%n");
        }
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
