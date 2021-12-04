package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int number = Arrays.stream(numbers).min().getAsInt();
        System.out.println(number);
    }
}
