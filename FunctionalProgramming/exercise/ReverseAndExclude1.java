package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Integer> numbers = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);
        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision);
        numbers.forEach(num -> System.out.print(num + " "));
    }
}
