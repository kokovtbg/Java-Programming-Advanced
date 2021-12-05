package IteratorsComparatos.exercise.StackIterator;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MainStackIterator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split(",?\\s+");
            String command = data[0];
            if (command.equals("Push")) {
                for (int i = 1; i < data.length; i++) {
                    stack.push(Integer.parseInt(data[i]));
                }
            } else if (command.equals("Pop")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    System.out.println("No elements");
                }
            }

            input = scan.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
