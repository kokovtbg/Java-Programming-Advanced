package SetsAndMaps.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!symbols.containsKey(input.charAt(i))) {
                symbols.put(input.charAt(i), 1);
            } else {
                symbols.put(input.charAt(i), symbols.get(input.charAt(i)) + 1);
            }
        }
        for (Map.Entry<Character, Integer> symbol : symbols.entrySet()) {
            System.out.printf("%c: %d time/s%n", symbol.getKey(), symbol.getValue());
        }
    }
}
