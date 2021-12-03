package Exams.Exam18August2021;

import java.util.ArrayList;
import java.util.List;

public class Cafe1 {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe1(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                this.employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        int ageOldestEmployee = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getAge() > ageOldestEmployee) {
                ageOldestEmployee = this.employees.get(i).getAge();
                oldestEmployee = this.employees.get(i);
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                return this.employees.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        String cafeToPrint = "Employees working at Cafe " + this.name + ":\n";
        StringBuilder employees = new StringBuilder();
        for (int i = 0; i < this.employees.size(); i++) {
            if (i < this.employees.size() - 1) {
                employees.append(this.employees.get(i)).append("\n");
            } else {
                employees.append(this.employees.get(i));
            }
        }
        cafeToPrint += employees.toString();
        return cafeToPrint;
    }
}
