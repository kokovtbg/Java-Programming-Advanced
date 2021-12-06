package SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Long>> countriesCitiesPopulation = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);
            Map<String, Long> cities;
            if (!countriesCitiesPopulation.containsKey(country)) {
                cities = new LinkedHashMap<>();
            } else {
                cities = countriesCitiesPopulation.get(country);
            }
            cities.put(city, population);
            cities = cities.entrySet().stream().sorted((a1, a2) -> Long.compare(a2.getValue(), a1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
            countriesCitiesPopulation.put(country, cities);

            input = scan.nextLine();
        }
        countriesCitiesPopulation = countriesCitiesPopulation.entrySet().stream().sorted((a1, a2) -> {
            long populationA1 = 0;
            for (Map.Entry<String, Long> entry : a1.getValue().entrySet()) {
                populationA1 += entry.getValue();
            }
            long populationA2 = 0;
            for (Map.Entry<String, Long> entry : a2.getValue().entrySet()) {
                populationA2 += entry.getValue();
            }
            return Long.compare(populationA2, populationA1);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        for (Map.Entry<String, Map<String, Long>> entry : countriesCitiesPopulation.entrySet()) {
            long population = 0;
            for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                population += entry2.getValue();
            }
            System.out.printf("%s (total population: %d)%n", entry.getKey(), population);
            for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                System.out.printf("=>%s: %d%n", entry2.getKey(), entry2.getValue());
            }
        }
    }
}
