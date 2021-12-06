package SetsAndMaps.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsProducts = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Revision")) {
            String[] data = input.split(",\\s+");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);
            Map<String, Double> products;
            if (!shopsProducts.containsKey(shop)) {
                products = new LinkedHashMap<>();
            } else {
                products = shopsProducts.get(shop);
            }
            products.put(product, price);
            shopsProducts.put(shop, products);

            input = scan.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : shopsProducts.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> entry2 : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry2.getKey(), entry2.getValue());
            }
        }
    }
}
