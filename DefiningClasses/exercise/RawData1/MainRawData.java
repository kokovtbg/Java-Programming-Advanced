package DefiningClasses.exercise.RawData1;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MainRawData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<EngineRawData> engines = new LinkedHashSet<>();
        Set<CargoRawData> cargos = new LinkedHashSet<>();
        Set<TireRawData> tires = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);
            EngineRawData engine = new EngineRawData(model, engineSpeed, enginePower);
            CargoRawData cargo = new CargoRawData(model, cargoWeight, cargoType);
            TireRawData tire = new TireRawData(model, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            engines.add(engine);
            cargos.add(cargo);
            tires.add(tire);
        }
        String input = scan.nextLine();
        if (input.equals("fragile")) {
            for (CargoRawData cargo : cargos) {
                if (cargo.getCargoType().equals(input)) {
                    for (TireRawData tire : tires) {
                        if (tire.getModel().equals(cargo.getModel())) {
                            if (tire.getTire1Pressure() < 1 || tire.getTire2Pressure() < 1 || tire.getTire3Pressure() < 1 || tire.getTire4Pressure() < 1) {
                                System.out.println(cargo.getModel());
                                break;
                            }
                        }
                    }
                }
            }
        } else if (input.equals("flamable")) {
            for (CargoRawData cargo : cargos) {
                if (cargo.getCargoType().equals(input)) {
                    for (EngineRawData engine : engines) {
                        if (engine.getModel().equals(cargo.getModel())) {
                            if (engine.getEnginePower() > 250) {
                                System.out.println(cargo.getModel());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
