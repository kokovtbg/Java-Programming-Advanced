package FunctionalProgramming.exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");

        Consumer<String> printWords = word -> System.out.println(word);
        for (int i = 0; i < words.length; i++) {
            printWords.accept(words[i]);
        }
    }
}
