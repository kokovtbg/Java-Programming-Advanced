package Exams.Exam26October2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersMales = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersFemales = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> males = new ArrayDeque<>();
        for (int i = 0; i < numbersMales.length; i++) {
            males.push(numbersMales[i]);
        }
        ArrayDeque<Integer> females = new ArrayDeque<>();
        for (int i = 0; i < numbersFemales.length; i++) {
            females.offer(numbersFemales[i]);
        }
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            if (males.peek() <= 0) {
                while (!males.isEmpty() && males.peek() <= 0) {
                    males.pop();
                }
            }
            if (!females.isEmpty() && females.peek() <= 0) {
                while (!females.isEmpty() && females.peek() <= 0) {
                    females.poll();
                }
            }
            if (!males.isEmpty() && males.peek() % 25 == 0) {
                males.pop();
                if (!males.isEmpty()) {
                    males.pop();
                }
            }
            if (!females.isEmpty() && females.peek() % 25 == 0) {
                females.poll();
                if (!females.isEmpty()) {
                    females.poll();
                }
            }
            if (!males.isEmpty() && !females.isEmpty() && males.peek().equals(females.peek())) {
                matches++;
                males.pop();
                females.poll();
            } else if (!males.isEmpty() && !females.isEmpty() && males.peek() % 25 != 0 && females.peek() % 25 != 0) {
                females.poll();
                int numberToPush = males.pop() - 2;
                males.push(numberToPush);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        if (males.isEmpty()) {
            System.out.printf("Males left: none%n");
        } else {
            System.out.print("Males left: ");
            System.out.println(String.join(", ", males.toString()).replace("[", "").replace("]", ""));
        }
        if (females.isEmpty()) {
            System.out.printf("Females left: none%n");
        } else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", females.toString().replace("[", "").replace("]", "")));
        }
    }
}
