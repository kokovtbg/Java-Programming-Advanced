package DefiningClasses.exercise.CompanyRoster2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainCompanyRoster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<CompanyRoster> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            if (data.length == 6) {
                String eMail = data[4];
                int age = Integer.parseInt(data[5]);
                CompanyRoster employee = new CompanyRoster(name, salary, position, department, eMail, age);
                employees.add(employee);
            } else if (data.length == 5) {
                if (data[4].contains("@")) {
                    String eMail = data[4];
                    CompanyRoster employee = new CompanyRoster(name, salary, position, department, eMail);
                    employees.add(employee);
                } else {
                    int age = Integer.parseInt(data[4]);
                    CompanyRoster employee = new CompanyRoster(name, salary, position, department, age);
                    employees.add(employee);
                }
            } else {
                CompanyRoster employee = new CompanyRoster(name, salary, position, department);
                employees.add(employee);
            }
        }
        employees = employees.stream().sorted(Comparator.comparing(CompanyRoster::getDepartment)).collect(Collectors.toList());
        double maxAvgSalary = 0;
        String bestDepartment = "";
        for (int i = 0; i < employees.size(); i++) {
            String department = employees.get(i).getDepartment();
            double avgSalary = 0;
            int count = 0;
            boolean haveToBreakAtLastElement = false;
            while (employees.get(i).getDepartment().equals(department)) {
                count++;
                avgSalary += employees.get(i).getSalary();
                if (i < employees.size() - 1) {
                    i++;
                } else {
                    haveToBreakAtLastElement = true;
                    break;
                }
            }
            i--;
            avgSalary /= count;
            if (avgSalary > maxAvgSalary) {
                maxAvgSalary = avgSalary;
                bestDepartment = employees.get(i).getDepartment();
            }
            if (haveToBreakAtLastElement) {
                break;
            }
        }
        employees = employees.stream().sorted((person1, person2) -> Double.compare(person2.getSalary(), person1.getSalary())).collect(Collectors.toList());
        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        for (CompanyRoster employee : employees) {
            if (employee.getDepartment().equals(bestDepartment)) {
                System.out.println(employee);
            }
        }
    }
}
