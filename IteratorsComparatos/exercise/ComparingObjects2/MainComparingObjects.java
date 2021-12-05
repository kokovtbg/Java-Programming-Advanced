package IteratorsComparatos.exercise.ComparingObjects2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainComparingObjects {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<ComparingObjects> people = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            ComparingObjects person = new ComparingObjects(name, age, town);
            people.add(person);

            input = scan.nextLine();
        }
        int number = Integer.parseInt(scan.nextLine());
        String name = people.get(number - 1).getName();
        int age = people.get(number - 1).getAge();
        String town = people.get(number - 1).getTown();
        int countEquals = 1;
        boolean hasEqual = false;
        for (int i = 0; i < people.size(); i++) {
            if (i != number - 1) {
                if (people.get(i).getName().compareTo(name) == 0) {
                    if (people.get(i).getAge() == age) {
                        if (people.get(i).getTown().compareTo(town) == 0) {
                            countEquals++;
                            hasEqual = true;
                        }
                    }
                }
            }
        }
        if (hasEqual) {
            System.out.printf("%d %d %d", countEquals, people.size() - countEquals, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
