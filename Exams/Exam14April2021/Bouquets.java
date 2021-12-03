package Exams.Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersTulips = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersDaffodils = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        for (int i = 0; i < numbersTulips.length; i++) {
            tulips.push(numbersTulips[i]);
        }
        for (int i = 0; i < numbersDaffodils.length; i++) {
            daffodils.offer(numbersDaffodils[i]);
        }
        int bouquets = 0;
        int flowers = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            if (tulips.peek() + daffodils.peek() == 15) {
                bouquets++;
                tulips.poll();
                daffodils.poll();
            } else if (tulips.peek() + daffodils.peek() > 15) {
                while (tulips.peek() + daffodils.peek() > 15) {
                    int number = tulips.pop() - 2;
                    tulips.push(number);
                }
                if (tulips.peek() + daffodils.peek() == 15) {
                    bouquets++;
                    tulips.pop();
                    daffodils.poll();
                } else {
                    flowers += tulips.pop() + daffodils.poll();
                }
            } else {
                flowers += tulips.pop() + daffodils.poll();
            }
        }
        bouquets += flowers / 15;
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
