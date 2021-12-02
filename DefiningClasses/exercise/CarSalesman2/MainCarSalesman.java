package DefiningClasses.exercise.CarSalesman2;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MainCarSalesman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<EngineCarSalesman> engines = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            String power = data[1];
            if (data.length == 2) {
                EngineCarSalesman engine = new EngineCarSalesman(model, power);
                engines.add(engine);
            } else if (data.length == 3 && Character.isDigit(data[2].charAt(0))) {
                String displacement = data[2];
                String efficiency = "n/a";
                EngineCarSalesman engine = new EngineCarSalesman(model, power, displacement, efficiency);
                engines.add(engine);
            } else if (data.length == 3) {
                String displacement = "n/a";
                String efficiency = data[2];
                EngineCarSalesman engine = new EngineCarSalesman(model, power, displacement, efficiency);
                engines.add(engine);
            } else {
                String displacement = data[2];
                String efficiency = data[3];
                EngineCarSalesman engine = new EngineCarSalesman(model, power, displacement, efficiency);
                engines.add(engine);
            }
        }
        int m = Integer.parseInt(scan.nextLine());
        Set<CarCarSalesman> cars = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            String engine = data[1];
            if (data.length == 2) {
                CarCarSalesman car = new CarCarSalesman(model, engine);
                cars.add(car);
            } else if (data.length == 3 && Character.isDigit(data[2].charAt(0))) {
                String weight = data[2];
                String color = "n/a";
                CarCarSalesman car = new CarCarSalesman(model, engine, weight, color);
                cars.add(car);
            } else if (data.length == 3) {
                String weight = "n/a";
                String color = data[2];
                CarCarSalesman car = new CarCarSalesman(model, engine, weight, color);
                cars.add(car);
            } else {
                String weight = data[2];
                String color = data[3];
                CarCarSalesman car = new CarCarSalesman(model, engine, weight, color);
                cars.add(car);
            }
        }
        for (CarCarSalesman car : cars) {
            System.out.println(car.getModel() + ":");
            for (EngineCarSalesman engine : engines) {
                if (car.getEngine().equals(engine.getModel())) {
                    System.out.println(engine.getModel() + ":");
                    System.out.printf("Power: %s%n", engine.getPower());
                    System.out.printf("Displacement: %s%n", engine.getDisplacement());
                    System.out.printf("Efficiency: %s%n", engine.getEfficiency());
                    System.out.printf("Weight: %s%n", car.getWeight());
                    System.out.printf("Color: %s%n", car.getColor());
                }
            }
        }
    }
}
