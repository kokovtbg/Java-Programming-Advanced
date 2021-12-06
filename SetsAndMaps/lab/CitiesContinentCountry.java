package SetsAndMaps.lab;

import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> continentCountry = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            Map<String, List<String>> countries;
            if (!continentCountry.containsKey(continent)) {
                countries = new LinkedHashMap<>();
            } else {
                countries = continentCountry.get(continent);
            }
            List<String> cities;
            if (!countries.containsKey(country)) {
                cities = new ArrayList<>();
            } else {
                cities = countries.get(country);
            }
            cities.add(city);
            countries.put(country, cities);
            continentCountry.put(continent, countries);
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : continentCountry.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (Map.Entry<String, List<String>> entry2 : entry.getValue().entrySet()) {
                System.out.printf("%s -> ", entry2.getKey());
                for (int i = 0; i < entry2.getValue().size(); i++) {
                    if (i < entry2.getValue().size() - 1) {
                        System.out.printf("%s, ", entry2.getValue().get(i));
                    } else {
                        System.out.printf("%s%n", entry2.getValue().get(i));
                    }
                }
            }
        }
    }
}
