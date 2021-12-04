package FunctionalProgramming.lab;

import java.util.Scanner;
import java.util.function.BiFunction;

public class SumNumbers1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split(",\\s+");
        BiFunction<Integer, String, Integer> parser = (x, y) ->  x + Integer.parseInt(y);
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = parser.apply(sum, numbers[i]);
        }
        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + sum);
    }
}
