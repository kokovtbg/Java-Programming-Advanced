package SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textToPattern = "(?<singer>[a-zA-Z]+ ?[a-zA-Z]+ ?[a-zA-Z]+) @(?<venue>[a-zA-Z]+ ?[a-zA-Z]+ ?[a-zA-Z]+) (?<ticketPrice>[0-9]+) (?<ticketsCount>[0-9]+)";

        Map<String, Map<String, Integer>> venuesSingers = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(textToPattern);
        String input = scan.nextLine();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                Map<String, Integer> singers;
                if (!venuesSingers.containsKey(matcher.group("venue"))) {
                    singers = new LinkedHashMap<>();
                    singers.put(matcher.group("singer"), Integer.parseInt(matcher.group("ticketPrice")) * Integer.parseInt(matcher.group("ticketsCount")));
                } else {
                    singers = venuesSingers.get(matcher.group("venue"));
                    if (!singers.containsKey(matcher.group("singer"))) {
                        singers.put(matcher.group("singer"), Integer.parseInt(matcher.group("ticketPrice")) * Integer.parseInt(matcher.group("ticketsCount")));
                    } else {
                        singers.put(matcher.group("singer"), singers.get(matcher.group("singer")) + Integer.parseInt(matcher.group("ticketPrice")) * Integer.parseInt(matcher.group("ticketsCount")));
                    }
                }
                singers = singers.entrySet().stream().sorted((a1, a2) -> Integer.compare(a2.getValue(), a1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
                venuesSingers.put(matcher.group("venue"), singers);
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : venuesSingers.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                System.out.printf("#  %s -> %d%n", entry2.getKey(), entry2.getValue());
            }
        }
    }
}
