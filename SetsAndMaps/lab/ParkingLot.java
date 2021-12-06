package SetsAndMaps.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] splitData = input.split(", ");
            String direction = splitData[0];
            String carNumber = splitData[1];
            if (direction.equals("IN")) {
                parking.add(carNumber);
            } else {
                parking.remove(carNumber);
            }

            input = scan.nextLine();
        }
        for (String number : parking) {
            System.out.printf("%s%n", number);
        }
        if (parking.isEmpty()) {
            System.out.printf("Parking Lot is Empty%n");
        }
    }
}
