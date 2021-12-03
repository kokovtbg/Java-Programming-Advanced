package Exams.Exam18August2021;

import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersLiquid = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersIngredients = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int i = 0; i < numbersLiquid.length; i++) {
            liquids.offer(numbersLiquid[i]);
        }
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i = 0; i < numbersIngredients.length; i++) {
            ingredients.push(numbersIngredients[i]);
        }
        Map<String, Integer> tableFoodCooked = new LinkedHashMap<>();
        tableFoodCooked.put("Biscuit", 0);
        tableFoodCooked.put("Cake", 0);
        tableFoodCooked.put("Pie", 0);
        tableFoodCooked.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            if (liquids.peek() + ingredients.peek() == 25) {
                tableFoodCooked.put("Biscuit", tableFoodCooked.get("Biscuit") + 1);
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == 50) {
                tableFoodCooked.put("Cake", tableFoodCooked.get("Cake") + 1);
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == 75) {
                tableFoodCooked.put("Pastry", tableFoodCooked.get("Pastry") + 1);
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == 100) {
                tableFoodCooked.put("Pie", tableFoodCooked.get("Pie") + 1);
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int amount = ingredients.pop() + 3;
                ingredients.push(amount);
            }
        }
        boolean allFoodCooked = true;
        for (Map.Entry<String, Integer> entry : tableFoodCooked.entrySet()) {
            if (entry.getValue() == 0) {
                allFoodCooked = false;
                break;
            }
        }
        if (allFoodCooked) {
            System.out.printf("Great! You succeeded in cooking all the food!%n");
        } else {
            System.out.printf("What a pity! You didn't have enough materials to cook everything.%n");
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
        for (Map.Entry<String, Integer> entry : tableFoodCooked.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
