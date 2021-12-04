package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;

public class FindEvensOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] bounds = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = scan.nextLine();
        int lowerBound = bounds[0];
        int upperBound = bounds[1];
        findEvenOddNumbers(lowerBound, upperBound, condition);
    }

    private static void findEvenOddNumbers(int lowerBound, int upperBound, String condition) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (condition.equals("even")) {
                if (i % 2 == 0) {
                    System.out.printf("%d ", i);
                }
            } else {
                if (i % 2 != 0) {
                    System.out.printf("%d ", i);
                }
            }
        }
    }
}
