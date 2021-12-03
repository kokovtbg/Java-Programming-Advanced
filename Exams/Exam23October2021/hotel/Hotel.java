package Exams.Exam23October2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                this.roster.remove(i);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name) && this.roster.get(i).getHometown().equals(hometown)) {
                return this.roster.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("The people in the hotel ").append(this.name).append(" are:").append(System.lineSeparator());
        for (int i = 0; i < this.roster.size(); i++) {
            if (i < this.roster.size() - 1) {
                statistics.append(this.roster.get(i)).append(System.lineSeparator());
            } else {
                statistics.append(this.roster.get(i));
            }
        }
        return statistics.toString();
    }
}
