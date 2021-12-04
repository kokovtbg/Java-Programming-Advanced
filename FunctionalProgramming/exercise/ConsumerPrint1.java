package FunctionalProgramming.exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] names = input.split("\\s+");
        Consumer<String[]> printNames = array -> {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        };
        printNames.accept(names);
    }
}
