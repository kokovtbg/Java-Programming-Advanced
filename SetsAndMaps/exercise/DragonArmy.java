package SetsAndMaps.exercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            int damage = 45;
            if (!data[2].equals("null")) {
                damage = Integer.parseInt(data[2]);
            }
            int health = 250;
            if (!data[3].equals("null")) {
                health = Integer.parseInt(data[3]);
            }
            int armor = 10;
            if (!data[4].equals("null")) {
                armor = Integer.parseInt(data[4]);
            }
            int[] damageHealthArmor = new int[3];
            damageHealthArmor[0] = damage;
            damageHealthArmor[1] = health;
            damageHealthArmor[2] = armor;
            Map<String, int[]> nameDragonDamageHealthArmor;
            if (!dragons.containsKey(type)) {
                nameDragonDamageHealthArmor = new TreeMap<>();
            } else {
                nameDragonDamageHealthArmor = dragons.get(type);
            }
            nameDragonDamageHealthArmor.put(name, damageHealthArmor);
            dragons.put(type, nameDragonDamageHealthArmor);
        }
        for (Map.Entry<String, Map<String, int[]>> entry : dragons.entrySet()) {
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            int count = 0;
            for (Map.Entry<String, int[]> entry2 : entry.getValue().entrySet()) {
                averageDamage += entry2.getValue()[0];
                averageHealth += entry2.getValue()[1];
                averageArmor += entry2.getValue()[2];
                count++;
            }
            averageDamage /= count;
            averageHealth /= count;
            averageArmor /= count;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), averageDamage, averageHealth, averageArmor);
            for (Map.Entry<String, int[]> entry2 : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", entry2.getKey(), entry2.getValue()[0], entry2.getValue()[1], entry2.getValue()[2]);
            }
        }
    }
}
