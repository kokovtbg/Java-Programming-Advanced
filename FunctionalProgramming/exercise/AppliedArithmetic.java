package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String command = scan.nextLine();
        while (!command.equals("end")) {
            arithmeticOperation(numbers, command);

            command = scan.nextLine();
        }
    }

    private static void arithmeticOperation(int[] numbers, String command) {
        if (command.equals("add")) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] += 1;
            }
        } else if (command.equals("multiply")) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] *= 2;
            }
        } else if (command.equals("subtract")) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] -= 1;
            }
        } else if (command.equals("print")){
            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("%d ", numbers[i]);
            }
            System.out.println();
        }
    }
}
