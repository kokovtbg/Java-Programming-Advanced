package DefiningClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCarConstructor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        CarConstructor carConstructor;
        List<CarConstructor> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            if (data.length == 3) {
                carConstructor = new CarConstructor(data[0], data[1], Integer.parseInt(data[2]));
            } else {
                carConstructor = new CarConstructor(data[0]);
            }
            cars.add(carConstructor);
        }
        printCar(cars);
    }

    private static void printCar(List<CarConstructor> cars) {
        for (CarConstructor car : cars) {
            System.out.println(car);
        }
    }
}
