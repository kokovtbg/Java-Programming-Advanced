package DefiningClasses.exercise.SpeedRacing2;

import java.util.*;

public class MainSpeedRacing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<SpeedRacing> cars = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCost = Double.parseDouble(data[2]);
            SpeedRacing car = new SpeedRacing(model, fuelAmount, fuelCost);
            cars.add(car);
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] data = command.split("\\s+");
            String model = data[1];
            int amountKM = Integer.parseInt(data[2]);
            for (SpeedRacing car : cars) {
                if (car.getModel().equals(model)) {
                    car.setFuelAmount(car.carCanMove(car.getFuelAmount(), car.getFuelCost(), amountKM));
                }
            }

            command = scan.nextLine();
        }
        for (SpeedRacing car : cars) {
            System.out.println(car);
        }
    }
}
