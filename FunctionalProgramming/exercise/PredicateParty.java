package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("Party!")) {
            String[] data = command.split("\\s+");
            party(names, data);

            command = scan.nextLine();
        }
        Collections.sort(names);
        if (names.size() > 0) {
            System.out.print(String.join(", ", names));
            System.out.printf(" are going to the party!%n");
        } else {
            System.out.printf("Nobody is going to the party!%n");
        }
    }

    private static void party(List<String> names, String[] data) {
        if (data[0].equals("Remove")) {
            switch (data[1]) {
                case "StartsWith":
                    for (int i = names.size() - 1; i >= 0; i--) {
                        if (names.get(i).startsWith(data[2])) {
                            names.remove(i);
                        }
                    }
                    break;
                case "EndsWith":
                    for (int i = names.size() - 1; i >= 0; i--) {
                        if (names.get(i).endsWith(data[2])) {
                            names.remove(i);
                        }
                    }
                    break;
                case "Length":
                    for (int i = names.size() - 1; i >= 0; i--) {
                        if (names.get(i).length() == Integer.parseInt(data[2])) {
                            names.remove(i);
                        }
                    }
                    break;
            }
        } else if (data[0].equals("Double")) {
            switch (data[1]) {
                case "StartsWith":
                    for (int i = names.size() - 1; i >= 0; i--) {
                        if (names.get(i).startsWith(data[2])) {
                            names.add(names.get(i));
                        }
                    }
                    break;
                case "EndsWith":
                    for (int i = names.size() - 1; i >= 0; i--) {
                        if (names.get(i).endsWith(data[2])) {
                            names.add(names.get(i));
                        }
                    }
                    break;
                case "Length":
                    for (int i = names.size() - 1; i >= 0; i--) {
                        if (names.get(i).length() == Integer.parseInt(data[2])) {
                            names.add(names.get(i));
                        }
                    }
                    break;
            }
        }
    }
}
