package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (first, second) -> {
            //първо четно, второ нечетно
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }
            //първо нечетно, второ четно
            else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            //първо четно, второ четно
            //първо нечетно, второ нечетно
            else {
                return first.compareTo(second);
                //first == second -> 0 няма размяна
                //first < second -> -1 няма размяна
                //first > second -> 1 има размяна
            }
        };
        numbers.stream().sorted(comparator).forEach(n -> System.out.print(n + " "));
    }
}
