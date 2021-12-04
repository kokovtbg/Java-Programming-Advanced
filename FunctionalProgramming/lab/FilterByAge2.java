package FunctionalProgramming.lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge2 {

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Person> people = IntStream.range(0, n).mapToObj(ignored -> {
            String[] tokens = scan.nextLine().split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        }).collect(Collectors.toList());

        String conditionParam = scan.nextLine();
        int agaLimit = Integer.parseInt(scan.nextLine());
        String[] format = scan.nextLine().split("\\s+");

        Predicate<Person> filter = getFilter(conditionParam, agaLimit);
        Consumer<Person> print = getPrinter(format);
        people.stream().filter(filter).forEach(print);
    }

    public static Predicate<Person> getFilter(String condition, int age) {
        if (condition.equals("older")) {
            return p -> p.age >= age;
        }
        return p -> p.age <= age;
    }

    public static Consumer<Person> getPrinter(String[] format) {
        if (format.length == 2) {
            return p -> System.out.println(p.name + " - " + p.age);
        } else if (format[0].equals("name")) {
            return p -> System.out.println(p.name);
        } else {
            return p -> System.out.println(p.age);
        }
    }
}
