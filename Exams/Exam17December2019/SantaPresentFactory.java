package Exams.Exam17December2019;

import java.util.*;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersMaterials = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersMagic = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        for (int i = 0; i < numbersMaterials.length; i++) {
            materials.push(numbersMaterials[i]);
        }
        ArrayDeque<Integer> magic = new ArrayDeque<>();
        for (int i = 0; i < numbersMagic.length; i++) {
            magic.offer(numbersMagic[i]);
        }
        Map<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);
        while (!materials.isEmpty() && !magic.isEmpty()) {
            if (materials.peek() * magic.peek() == 150) {
                presents.put("Doll", presents.get("Doll") + 1);
                materials.pop();
                magic.poll();
            } else if (materials.peek() * magic.peek() == 250) {
                presents.put("Wooden train", presents.get("Wooden train") + 1);
                materials.pop();
                magic.poll();
            } else if (materials.peek() * magic.peek() == 300) {
                presents.put("Teddy bear", presents.get("Teddy bear") + 1);
                materials.pop();
                magic.poll();
            } else if (materials.peek() * magic.peek() == 400) {
                presents.put("Bicycle", presents.get("Bicycle") + 1);
                materials.pop();
                magic.poll();
            } else if (materials.peek() * magic.peek() < 0) {
                int sum = materials.pop() + magic.poll();
                materials.push(sum);
            } else if (materials.peek() * magic.peek() > 0) {
                magic.poll();
                int numberToPush = materials.pop() + 15;
                materials.push(numberToPush);
            } else if (materials.peek() * magic.peek() == 0) {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magic.peek() == 0) {
                    magic.poll();
                }
            }
        }
        boolean merryChristmas = false;
        if (presents.get("Doll") > 0 && presents.get("Wooden train") > 0) {
            merryChristmas = true;
        }
        if (presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0) {
            merryChristmas = true;
        }
        if (merryChristmas) {
            System.out.printf("The presents are crafted! Merry Christmas!%n");
        } else {
            System.out.printf("No presents this Christmas!%n");
        }
        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(String.join(", ", materials.toString()).replace("[", "").replace("]", ""));
        }
        if (!magic.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(String.join(", ", magic.toString()).replace("[", "").replace("]", ""));
        }
        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
