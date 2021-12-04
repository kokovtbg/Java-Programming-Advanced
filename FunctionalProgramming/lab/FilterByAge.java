package FunctionalProgramming.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(",\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            people.put(name,age);
        }
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();
        if (condition.equals("younger")) {
            if (format.equals("name")) {
                people.entrySet().stream().filter(a -> a.getValue() <= age).forEach(a -> System.out.printf("%s%n", a.getKey()));
            } else if (format.equals("age")) {
                people.entrySet().stream().filter(a -> a.getValue() <= age).forEach(a -> System.out.printf("%d%n", a.getValue()));
            } else {
                people.entrySet().stream().filter(a -> a.getValue() <= age).forEach(a -> System.out.printf("%s - %d%n", a.getKey(), a.getValue()));
            }
        } else {
            if (format.equals("name")) {
                people.entrySet().stream().filter(a -> a.getValue() >= age).forEach(a -> System.out.printf("%s%n", a.getKey()));
            } else if (format.equals("age")) {
                people.entrySet().stream().filter(a -> a.getValue() >= age).forEach(a -> System.out.printf("%d%n", a.getValue()));
            } else {
                people.entrySet().stream().filter(a -> a.getValue() >= age).forEach(a -> System.out.printf("%s - %d%n", a.getKey(), a.getValue()));
            }
        }
    }
}
