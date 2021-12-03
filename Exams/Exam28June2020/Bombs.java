package Exams.Exam28June2020;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersBombEffects = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersBombCasings = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        for (int i = 0; i < numbersBombEffects.length; i++) {
            bombEffects.offer(numbersBombEffects[i]);
        }
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        for (int i = 0; i < numbersBombCasings.length; i++) {
            bombCasings.push(numbersBombCasings[i]);
        }
        Map<String, Integer> pouch = new TreeMap<>();
        pouch.put("Datura Bombs", 0);
        pouch.put("Cherry Bombs", 0);
        pouch.put("Smoke Decoy Bombs", 0);
        boolean allBombs = true;
        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            if (bombEffects.peek() + bombCasings.peek() == 40) {
                bombEffects.poll();
                bombCasings.pop();
                pouch.put("Datura Bombs", pouch.get("Datura Bombs") + 1);
            } else if (bombEffects.peek() + bombCasings.peek() == 60) {
                bombEffects.poll();
                bombCasings.pop();
                pouch.put("Cherry Bombs", pouch.get("Cherry Bombs") + 1);
            } else if (bombEffects.peek() + bombCasings.peek() == 120) {
                bombEffects.poll();
                bombCasings.pop();
                pouch.put("Smoke Decoy Bombs", pouch.get("Smoke Decoy Bombs") + 1);
            } else {
                int numberToPush = bombCasings.pop() - 5;
                bombCasings.push(numberToPush);
            }
            allBombs = true;
            for (Map.Entry<String, Integer> entry : pouch.entrySet()) {
                if (entry.getValue() < 3) {
                    allBombs = false;
                }
            }
            if (allBombs) {
                break;
            }
        }
        if (allBombs) {
            System.out.printf("Bene! You have successfully filled the bomb pouch!%n");
        } else {
            System.out.printf("You don't have enough materials to fill the bomb pouch.%n");
        }
        if (bombEffects.isEmpty()) {
            System.out.printf("Bomb Effects: empty%n");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.println(String.join(", ", bombEffects.toString()).replace("[", "").replace("]", ""));
        }
        if (bombCasings.isEmpty()) {
            System.out.printf("Bomb Casings: empty%n");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.println(String.join(", ", bombCasings.toString()).replace("[", "").replace("]", ""));
        }
        for (Map.Entry<String, Integer> entry : pouch.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
