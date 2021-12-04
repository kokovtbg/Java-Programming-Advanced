package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split(",\\s+")).collect(Collectors.toList());
        System.out.println("Count = " + numbers.size());
        Function<String, Integer> parser = x -> Integer.parseInt(x);
        int sum = 0;
        for (String s : numbers) {
            sum += parser.apply(s);
        }
        System.out.println("Sum = " + sum);
    }
}
