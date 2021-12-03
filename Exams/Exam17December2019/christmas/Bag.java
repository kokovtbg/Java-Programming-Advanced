package Exams.Exam17December2019.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        Present heaviestPresent = null;
        double weightHeaviestPresent = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getWeight() > weightHeaviestPresent) {
                weightHeaviestPresent = this.data.get(i).getWeight();
                heaviestPresent = this.data.get(i);
            }
        }
        return heaviestPresent;
    }

    public Present getPresent(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(this.color).append(" bag contains:").append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            if (i < this.data.size() - 1) {
                report.append(this.data.get(i)).append(System.lineSeparator());
            } else {
                report.append(this.data.get(i));
            }
        }
        return report.toString();
    }
}
