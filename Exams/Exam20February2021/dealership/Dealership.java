package Exams.Exam20February2021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) && this.data.get(i).getModel().equals(model)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.size() > 0) {
            int latestYear = 0;
            Car latestCar = null;
            for (int i = 0; i < this.data.size(); i++) {
                if (this.data.get(i).getYear() > latestYear) {
                    latestYear = this.data.get(i).getYear();
                    latestCar = this.data.get(i);
                }
            }
            return latestCar;
        } else {
            return null;
        }
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) && this.data.get(i).getModel().equals(model)) {
                car = this.data.get(i);
            }
        }
        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        String statistics = "The cars are in a car dealership " + this.name + ":" + System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.data.size(); i++) {
            if (i < this.data.size() - 1) {
                builder.append(this.data.get(i)).append(System.lineSeparator());
            } else {
                builder.append(this.data.get(i));
            }
        }
        statistics += builder;
        return statistics;
    }
}
