package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
//        2 + 5 + 10 - 2 - 1 = 14
        String[] numbersOperations = input.split(" ");
        ArrayDeque<Integer> result = new ArrayDeque<>();
        ArrayDeque<String> operations = new ArrayDeque<>();
        for (int i = 0; i < numbersOperations.length; i++) {
            if (i == 0) {
                result.push(Integer.parseInt(numbersOperations[i]));
            } else if (i % 2 == 0) {
                int number = Integer.parseInt(numbersOperations[i]);
                if (operations.peek().equals("+")) {
                    result.push(result.peek() + number);
                } else if (operations.peek().equals("-")) {
                    result.push(result.peek() - number);
                }
            } else {
                operations.push(numbersOperations[i]);
            }
        }
        System.out.println(result.peek());
    }
}
