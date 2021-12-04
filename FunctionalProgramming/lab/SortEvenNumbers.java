package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(",\\s+")).map(Integer::parseInt).filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(String.join(", ", numbers + "").replaceAll("\\[", "").replaceAll("\\]", ""));
        Collections.sort(numbers);
        System.out.println(String.join(", ", numbers + "").replaceAll("\\[", "").replaceAll("\\]", ""));

    }
}
