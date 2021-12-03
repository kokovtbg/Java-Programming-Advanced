package Exams.Exam26October2019.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                this.data.remove(i);
                i = -1;
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).isAvailable()) {
                this.data.get(i).setAvailable(false);
                rabbit = this.data.get(i);
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                this.data.get(i).setAvailable(false);
                rabbits.add(this.data.get(i));
            }
        }
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Rabbits available at ").append(this.name).append(":").append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).isAvailable()) {
                if (i < this.data.size() - 1) {
                    report.append(this.data.get(i)).append(System.lineSeparator());
                } else {
                    report.append(this.data.get(i));
                }
            }
        }
        return report.toString();
    }
}
