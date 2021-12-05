package IteratorsComparatos.exercise.StrategyPattern2;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Person> nameSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new AgeComparator());
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < lines; i++) {
            String line = scan.nextLine();
            String[] nameParameters = line.split(" ");
            String name = nameParameters[0];
            int age = Integer.parseInt(nameParameters[1]);
            Person person = new Person(name, age);
            nameSet.add(person);
            ageSet.add(person);
        }
        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
