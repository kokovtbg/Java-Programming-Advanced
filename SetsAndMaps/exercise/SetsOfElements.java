package SetsAndMaps.exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = numbers[0];
        int m = numbers[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scan.nextLine());
            secondSet.add(number);
        }
        for (Integer numberOne : firstSet) {
            for (Integer numberTwo : secondSet) {
                if (numberOne.equals(numberTwo)) {
                    System.out.printf("%d ", numberOne);
                }
            }
        }
    }
}
