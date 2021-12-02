package DefiningClasses.exercise.CompanyRoster2;

public class CompanyRoster {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String eMail;
    private int age;

    public CompanyRoster(String name, double salary, String position, String department, String eMail, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.eMail = eMail;
        this.age = age;
    }

    public CompanyRoster(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.eMail = "n/a";
        this.age = -1;
    }

    public CompanyRoster(String name, double salary, String position, String department, String eMail) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.eMail = eMail;
        this.age = -1;
    }

    public CompanyRoster(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.eMail = "n/a";
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.eMail, this.age);
    }
}
