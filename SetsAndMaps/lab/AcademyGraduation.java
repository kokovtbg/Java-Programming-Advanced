package SetsAndMaps.lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Double> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String nameStudent = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double avgGrade = 0;
            for (int j = 0; j < grades.length; j++) {
                avgGrade += grades[j];
            }
            avgGrade /= grades.length;
            students.put(nameStudent, avgGrade);
        }
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}
