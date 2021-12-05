package IteratorsComparatos.exercise.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCollection {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        int count = 0;
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String command = data[0];
            if (command.equals("Create")) {
                if (data.length > 1) {
                    for (int i = 1; i < data.length; i++) {
                        list.add(data[i]);
                    }
                }
            } else if (command.equals("Move")) {
                if (count + 1 < list.size()) {
                    System.out.println("true");
                    count++;
                } else {
                    System.out.println("false");
                }
            } else if (command.equals("Print")) {
                if (list.size() > 0) {
                    System.out.println(list.get(count));
                } else {
                    System.out.println("Invalid Operation!");
                }
            } else if (command.equals("HasNext")) {
                if (count + 1 < list.size()) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else if (command.equals("PrintAll")) {
                if (list.size() > 0) {
                    System.out.println(String.join(" ", list));
                } else {
                    System.out.println("Invalid Operation!");
                }
            }

            input = scan.nextLine();
        }
    }
}
