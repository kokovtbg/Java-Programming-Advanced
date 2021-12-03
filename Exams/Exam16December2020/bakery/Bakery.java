package Exams.Exam16December2020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                this.employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int yearOldestEmployee = 0;
        Employee oldestEmployee = null;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getAge() > yearOldestEmployee) {
                yearOldestEmployee = this.employees.get(i).getAge();
                oldestEmployee = this.employees.get(i);
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                return this.employees.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        String report = "Employees working at Bakery " + this.name + ":" + System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.employees.size(); i++) {
            if (i < this.employees.size() - 1) {
                builder.append(this.employees.get(i)).append(System.lineSeparator());
            } else {
                builder.append(this.employees.get(i));
            }
        }
        report += builder.toString();
        return report;
    }
}
