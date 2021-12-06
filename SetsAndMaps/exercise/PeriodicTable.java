package SetsAndMaps.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<String> periodicTable = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] data = input.split("\\s+");
            periodicTable.addAll(Arrays.asList(data));
        }
        for (String element : periodicTable) {
            System.out.printf("%s ", element);
        }
    }
}
