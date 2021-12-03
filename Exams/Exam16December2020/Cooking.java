package Exams.Exam16December2020;

import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersLiquids = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersIngredients = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int i = 0; i < numbersLiquids.length; i++) {
            liquids.offer(numbersLiquids[i]);
        }
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i = 0; i < numbersIngredients.length; i++) {
            ingredients.push(numbersIngredients[i]);
        }
        Map<String, Integer> bakedFood = new TreeMap<>();
        bakedFood.put("Bread", 0);
        bakedFood.put("Cake", 0);
        bakedFood.put("Pastry", 0);
        bakedFood.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            if (liquids.peek() + ingredients.peek() == 25) {
                bakedFood.put("Bread", bakedFood.get("Bread") + 1);
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == 50) {
                bakedFood.put("Cake", bakedFood.get("Cake") + 1);
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == 75) {
                bakedFood.put("Pastry", bakedFood.get("Pastry") + 1);
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == 100) {
                bakedFood.put("Fruit Pie", bakedFood.get("Fruit Pie") + 1);
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int numberToPush = ingredients.pop() + 3;
                ingredients.push(numberToPush);
            }
        }
        boolean allFoodCooked = true;
        for (Map.Entry<String, Integer> entry : bakedFood.entrySet()) {
            if (entry.getValue() == 0) {
                allFoodCooked = false;
                break;
            }
        }
        if (allFoodCooked) {
            System.out.printf("Wohoo! You succeeded in cooking all the food!%n");
        } else {
            System.out.printf("Ugh, what a pity! You didn't have enough materials to cook everything.%n");
        }
        if (liquids.isEmpty()) {
            System.out.printf("Liquids left: none%n");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(String.join(", ", liquids.toString()).replace("[", "").replace("]", ""));
        }
        if (ingredients.isEmpty()) {
            System.out.printf("Ingredients left: none%n");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(String.join(", ", ingredients.toString()).replace("[", "").replace("]", ""));
        }
        for (Map.Entry<String, Integer> entry : bakedFood.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
