package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestElement = list -> {
            int smallestElement = Integer.MAX_VALUE;
            int smallestElementIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= smallestElement) {
                    smallestElement = list.get(i);
                    smallestElementIndex = i;
                }
            }
            return smallestElementIndex;
        };
        int smallestElementIndex = findSmallestElement.apply(numbers);
        System.out.println(smallestElementIndex);
    }
}
