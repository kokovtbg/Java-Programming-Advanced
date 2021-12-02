package DefiningClasses.exercise.SpeedRacing1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scan.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int fuelAmount = Integer.parseInt(input[1]);
            double consumption = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, consumption);
            cars.put(model, car);
        }
        String[] command = scan.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            String carModel = command[1];
            double kilometersToDrive = Double.parseDouble(command[2]);
            Car car = cars.get(carModel);
            if (!car.drive(kilometersToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

             command = scan.nextLine().split("\\s+");
        }
        cars.forEach((key, value) -> System.out.println(value));
    }
}
