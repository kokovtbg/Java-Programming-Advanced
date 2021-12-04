package FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> prices = Arrays.stream(scan.nextLine().split(",\\s+")).map(Double::parseDouble).collect(Collectors.toList());

        Function<Double, Double> addVAT = price -> price * 1.2;
        List<Double> pricesWithVAT = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            pricesWithVAT.add(addVAT.apply(prices.get(i)));
        }
        System.out.println("Prices with VAT:");
        pricesWithVAT.forEach(a -> System.out.printf("%.2f%n", a));
    }
}
