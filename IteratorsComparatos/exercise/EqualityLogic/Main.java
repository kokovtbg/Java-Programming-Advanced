package IteratorsComparatos.exercise.EqualityLogic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<Person> peopleTreeSet = new TreeSet<>(new NameAgeComparator());
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            peopleTreeSet.add(person);
        }
        Set<Person> peopleHashSet = new HashSet<>(peopleTreeSet);
        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashSet.size());
    }
}
