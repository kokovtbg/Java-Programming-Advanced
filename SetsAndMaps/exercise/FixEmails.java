package SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int count = 0;
        String name = "";
        Map<String, String> listEmails = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            count++;
            if (count % 2 != 0) {
                name = input;
            } else {
                String domain = input.substring(input.lastIndexOf(".") + 1).toLowerCase();
                if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                    listEmails.put(name, input);
                }
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : listEmails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
