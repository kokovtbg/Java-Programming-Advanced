package IteratorsComparatos.exercise.LinkedListTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String commandLine = scan.nextLine();
            String[] commandParts = commandLine.split("\\s+");
            String command = commandParts[0];
            if (command.equals("Add")) {
                numbers.add(commandParts[1]);
            } else {
                String number = commandParts[1];
                numbers.remove(number);
            }
        }
        System.out.println(numbers.size());
        numbers.forEach(num -> System.out.printf("%s ", num));
    }
}
