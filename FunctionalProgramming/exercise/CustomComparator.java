package FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Predicate<Integer> evenNumber = num -> num % 2 == 0;
        Predicate<Integer> oddNumber = num -> num % 2 != 0;
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (evenNumber.test(numbers[i])) {
                evenNumbers.add(numbers[i]);
            } else if (oddNumber.test(numbers[i])) {
                oddNumbers.add(numbers[i]);
            }
        }
        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);
        evenNumbers.forEach(num -> System.out.printf("%d ", num));
        oddNumbers.forEach(num -> System.out.printf("%d ", num));
    }
}
