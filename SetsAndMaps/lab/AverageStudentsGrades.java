package SetsAndMaps.lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String nameStudent = data[0];
            double grade = Double.parseDouble(data[1]);
            List<Double> grades;
            if (!students.containsKey(nameStudent)) {
                grades = new ArrayList<>();
            } else {
                grades = students.get(nameStudent);
            }
            grades.add(grade);
            students.put(nameStudent, grades);
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double averageGrade = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                averageGrade += entry.getValue().get(i);
                System.out.printf("%.2f ", entry.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)%n", averageGrade / entry.getValue().size());
        }
    }
}
