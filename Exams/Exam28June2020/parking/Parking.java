package Exams.Exam28June2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) && this.data.get(i).getModel().equals(model)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        int ageLatestCar = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getYear() > ageLatestCar) {
                ageLatestCar = this.data.get(i).getYear();
                car = this.data.get(i);
            }
        }
        return car;
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
        StringBuilder statistics = new StringBuilder();
        statistics.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            if (i < this.data.size() - 1) {
                statistics.append(this.data.get(i)).append(System.lineSeparator());
            } else {
                statistics.append(this.data.get(i));
            }
        }
        return statistics.toString();
    }
}
