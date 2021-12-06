package SetsAndMaps.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        boolean shadowmourneObtained = false;
        boolean valanyrObtained = false;
        boolean dragonwrathObtained = false;
        Map<String, Integer> junk = new TreeMap<>();
        String input = scan.nextLine();
        while (materials.get("shards") < 250 && materials.get("fragments") < 250 && materials.get("motes") < 250) {
            String[] data = input.split("\\s+");
            int quantity = 0;
            for (int i = 0; i < data.length; i++) {
                if (i % 2 == 0) {
                    quantity = Integer.parseInt(data[i]);
                } else {
                    String material = data[i].toLowerCase();
                    if (materials.containsKey(material)) {
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get(material) >= 250) {
                            materials.put(material, materials.get(material) - 250);
                            if (material.equals("shards")) {
                                shadowmourneObtained = true;
                            } else if (material.equals("fragments")) {
                                valanyrObtained = true;
                            } else {
                                dragonwrathObtained = true;
                            }
                            break;
                        }
                    } else {
                        if (!junk.containsKey(material)) {
                            junk.put(material, quantity);
                        } else {
                            junk.put(material, junk.get(material) + quantity);
                        }
                    }
                }
            }
            if (shadowmourneObtained || valanyrObtained || dragonwrathObtained) {
                break;
            }
            input = scan.nextLine();
        }
        if (shadowmourneObtained) {
            System.out.println("Shadowmourne obtained!");
        } else if (valanyrObtained) {
            System.out.println("Valanyr obtained!");
        } else if (dragonwrathObtained) {
            System.out.println("Dragonwrath obtained!");
        }
        materials.entrySet().stream().sorted((a1, a2) -> Integer.compare(a2.getValue(), a1.getValue())).forEach(a -> System.out.printf("%s: %d%n", a.getKey(), a.getValue()));
        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
