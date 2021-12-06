package SetsAndMaps.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
