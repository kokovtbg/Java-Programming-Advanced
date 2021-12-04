package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numberToDivide = Integer.parseInt(scan.nextLine());
        BiFunction<Integer, Integer, Boolean> isNotDividable = (number, divider) -> number % divider != 0;
        Consumer<Integer> printTheNumber = num -> System.out.printf("%d ", num);
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (isNotDividable.apply(numbers[i], numberToDivide)) {
                printTheNumber.accept(numbers[i]);
            }
        }
    }
}
