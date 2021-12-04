package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> vatCalculator = vat -> vat * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(scan.nextLine().split(", ")).map(Double::parseDouble).map(vatCalculator).forEach(p -> System.out.printf("%.2f%n", p));

    }
}
