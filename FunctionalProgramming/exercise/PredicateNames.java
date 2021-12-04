package FunctionalProgramming.exercise;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Predicate<Integer> lessOrEqualLength = x -> x <= n;
        for (int i = 0; i < names.length; i++) {
            if (lessOrEqualLength.test(names[i].length())) {
                System.out.println(names[i]);
            }
        }
    }
}
