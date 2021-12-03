package Exams.Exam16December2020.bakery;

public class Employee {
    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", this.name, this.age, this.country);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
