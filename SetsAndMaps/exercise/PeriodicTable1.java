package SetsAndMaps.exercise;

import java.util.*;

public class PeriodicTable1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<String> periodicTable = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] data = input.split("\\s+");
            Collections.addAll(periodicTable, data);
        }
        for (String element : periodicTable) {
            System.out.printf("%s ", element);
        }
    }
}
