package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    primaryDiagonalSum += matrix[i][j];
                }
                if (j == n - 1 - i) {
                    secondaryDiagonalSum += matrix[i][j];
                }
            }
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}
