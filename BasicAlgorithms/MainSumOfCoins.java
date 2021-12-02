package BasicAlgorithms;

import java.util.*;
import java.util.stream.Collectors;

public class MainSumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        boolean validCoins = validateCoins(coins);
        if (validCoins) {
            Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
            int sumCoins = usedCoins.values().stream().mapToInt(i -> i).sum();
            System.out.printf("Number of coins to take: %d%n", sumCoins);

            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                if (usedCoin.getValue() != 0) {
                    System.out.println(usedCoin.getValue() + " coin(s) with value " + usedCoin.getKey());
                }
            }
        } else {
            System.out.println("Error");
        }

    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
       // TODO

        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            usedCoins.put(coins[i], 0);
        }
        for (Map.Entry<Integer, Integer> entry : usedCoins.entrySet()) {
            int count = targetSum / entry.getKey();
            entry.setValue(count);
            targetSum -= entry.getKey() * count;
        }
        return usedCoins;
    }

    private static boolean validateCoins(int[] coins) {
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] != 1 && coins[i] != 2 && coins[i] != 5 && coins[i] != 10 && coins[i] != 20 && coins[i] != 50) {
                return false;
            }
        }
        return true;
    }
}