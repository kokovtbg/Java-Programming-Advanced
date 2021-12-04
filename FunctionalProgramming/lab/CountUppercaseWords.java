package FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        List<String> wordsWithUpperCase = new ArrayList<>();
        Predicate<String> isUppercase = word -> word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        for (int i = 0; i < words.size(); i++) {
            if (isUppercase.test(words.get(i))) {
                wordsWithUpperCase.add(words.get(i));
            }
        }
        System.out.println(wordsWithUpperCase.size());
        wordsWithUpperCase.forEach(System.out::println);
    }
}
