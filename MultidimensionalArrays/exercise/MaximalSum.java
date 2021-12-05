package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] matrixMax = new int[3][3];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = 0;
                sum += matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    matrixMax[0][0] = matrix[i][j];
                    matrixMax[0][1] = matrix[i][j + 1];
                    matrixMax[0][2] = matrix[i][j + 2];
                    matrixMax[1][0] = matrix[i + 1][j];
                    matrixMax[1][1] = matrix[i + 1][j + 1];
                    matrixMax[1][2] = matrix[i + 1][j + 2];
                    matrixMax[2][0] = matrix[i + 2][j];
                    matrixMax[2][1] = matrix[i + 2][j + 1];
                    matrixMax[2][2] = matrix[i + 2][j + 2];
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", matrixMax[i][j]);
            }
            System.out.println();
        }
    }
}
