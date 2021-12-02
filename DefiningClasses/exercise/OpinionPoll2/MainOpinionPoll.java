package DefiningClasses.exercise.OpinionPoll2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainOpinionPoll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<OpinionPoll> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            OpinionPoll person = new OpinionPoll(name, age);
            persons.add(person);
        }
        persons.stream().filter(person -> person.getAge() > 30).sorted(Comparator.comparing(OpinionPoll::getName)).forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));
    }
}
