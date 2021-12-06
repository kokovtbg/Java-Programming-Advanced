package SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int count = 0;
        String resource = "";
        Map<String, Integer> miner = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            count++;
            if (count % 2 != 0) {
                resource = input;
            } else {
                int quantity = Integer.parseInt(input);
                if (!miner.containsKey(resource)) {
                    miner.put(resource, quantity);
                } else {
                    miner.put(resource, miner.get(resource) + quantity);
                }
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : miner.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
