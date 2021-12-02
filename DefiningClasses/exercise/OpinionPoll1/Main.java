package DefiningClasses.exercise.OpinionPoll1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        people.stream().filter(p -> p.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
    }
}
