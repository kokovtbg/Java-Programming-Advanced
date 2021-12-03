package Exams.Exam19August2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
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
        Pet pet = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).getOwner().equals(owner)) {
                pet = this.data.get(i);
            }
        }
        return pet;
    }

    public Pet getOldestPet() {
        Pet pet = null;
        int ageOldestPet = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getAge() > ageOldestPet) {
                pet = this.data.get(i);
                ageOldestPet = this.data.get(i).getAge();
            }
        }
        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("The clinic has the following patients:").append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            if (i < this.data.size() - 1) {
                statistics.append(this.data.get(i).getName()).append(" ").append(this.data.get(i).getOwner()).append(System.lineSeparator());
            } else {
                statistics.append(this.data.get(i).getName()).append(" ").append(this.data.get(i).getOwner());
            }
        }
        return statistics.toString();
    }
}
