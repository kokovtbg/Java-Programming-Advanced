package DefiningClasses.exercise.CarSalesman1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = null;
            if (input.length == 2) {
                engine = new Engine(model, power);
            } else if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (input.length == 3) {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = input[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.put(model, engine);
        }
        int m = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            Engine carEngine = engines.get(engineModel);
            Car car = null;
            if (input.length == 2) {
                car = new Car(model, carEngine);
            } else if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new Car(model, carEngine, weight, color);
            } else if (input.length == 3) {
                try {
                    int weight = Integer.parseInt(input[2]);
                    car = new Car(model, carEngine, weight);
                } catch (NumberFormatException e) {
                    String color = input[2];
                    car = new Car(model, carEngine, color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
