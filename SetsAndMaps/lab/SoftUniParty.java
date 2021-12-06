package SetsAndMaps.lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> party = new TreeSet<>();
        String input = scan.nextLine();
        while (!input.equals("PARTY")) {
            party.add(input);

            input = scan.nextLine();
        }
        String command = scan.nextLine();
        while (!command.equals("END")) {
            party.remove(command);

            command = scan.nextLine();
        }
        System.out.printf("%d%n", party.size());
        for (String person : party) {
            System.out.printf("%s%n", person);
        }
    }
}
