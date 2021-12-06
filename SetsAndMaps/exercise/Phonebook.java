package SetsAndMaps.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];
            phonebook.put(name, number);

            input = scan.nextLine();
        }
        String command = scan.nextLine();
        while (!command.equals("stop")) {
            if (phonebook.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, phonebook.get(command));
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }

            command = scan.nextLine();
        }
    }
}
