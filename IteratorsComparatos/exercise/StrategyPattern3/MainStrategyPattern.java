package IteratorsComparatos.exercise.StrategyPattern3;

import java.util.Scanner;
import java.util.TreeSet;

public class MainStrategyPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeSet<StrategyPattern> names = new TreeSet<>();
        TreeSet<StrategyPattern1> names1 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            StrategyPattern person = new StrategyPattern(name, age);
            StrategyPattern1 person1 = new StrategyPattern1(name, age);
            names.add(person);
            names1.add(person1);
        }
        names.forEach(System.out::println);
        names1.forEach(System.out::println);
    }
}
