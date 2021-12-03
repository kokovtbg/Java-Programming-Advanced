package Exams.Exam23October2021;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersIngredients = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i = 0; i < numbersIngredients.length; i++) {
            ingredients.offer(numbersIngredients[i]);
        }
        int[] numbersFreshness = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (int i = 0; i < numbersFreshness.length; i++) {
            freshness.push(numbersFreshness[i]);
        }
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);
        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            if (ingredients.peek() == 0) {
                while (!ingredients.isEmpty() && ingredients.peek() == 0) {
                    ingredients.poll();
                }
                if (ingredients.isEmpty()) {
                    break;
                }
            }
            if (ingredients.peek() * freshness.peek() == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                ingredients.poll();
                freshness.pop();
            } else if (ingredients.peek() * freshness.peek() == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                ingredients.poll();
                freshness.pop();
            } else if (ingredients.peek() * freshness.peek() == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                ingredients.poll();
                freshness.pop();
            } else if (ingredients.peek() * freshness.peek() == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                ingredients.poll();
                freshness.pop();
            } else {
                freshness.pop();
                int numberToOffer = ingredients.poll() + 5;
                ingredients.offer(numberToOffer);
            }
        }
        boolean haveAllCocktails = true;
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() < 1) {
                haveAllCocktails = false;
                break;
            }
        }
        if (haveAllCocktails) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int sum = 0;
            while (!ingredients.isEmpty()) {
                sum += ingredients.poll();
            }
            System.out.println("Ingredients left: " + sum);
        }
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
