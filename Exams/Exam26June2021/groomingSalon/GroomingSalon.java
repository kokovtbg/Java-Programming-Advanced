package Exams.Exam26June2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
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

    public Pet getPet(String name, String owner) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).getOwner().equals(owner)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        String statistics = "The grooming salon has the following clients:" + System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.data.size(); i++) {
            if (i < this.data.size() - 1) {
                builder.append(this.data.get(i).getName()).append(" ").append(this.data.get(i).getOwner()).append(System.lineSeparator());
            } else {
                builder.append(this.data.get(i).getName()).append(" ").append(this.data.get(i).getOwner());
            }
        }
        statistics += builder.toString();
        return statistics;
    }
}
