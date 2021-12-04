package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class SumNumbers2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Function<String, Integer> countIntegersInString = str -> str.split(", ").length;
        Function<String, Integer> sumIntegersInString = str -> Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).sum();

        Consumer<Integer> printCount = num -> System.out.println("Count = " + num);
        Consumer<Integer> printSum = num -> System.out.println("Sum = " + num);
        printCount.accept(countIntegersInString.apply(input));
        printSum.accept(sumIntegersInString.apply(input));
    }
}
