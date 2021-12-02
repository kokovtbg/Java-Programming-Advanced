package DefiningClasses.lab;

import java.util.Scanner;

public class MainCar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Car car = new Car();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            car.setBrand(data[0]);
            car.setModel(data[1]);
            car.setHorsePower(Integer.parseInt(data[2]));
            carInfo(car.getBrand(), car.getModel(), car.getHorsePower());
        }
    }

    private static void carInfo(String brand, String model, int horsePower) {
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, horsePower);
    }
}
