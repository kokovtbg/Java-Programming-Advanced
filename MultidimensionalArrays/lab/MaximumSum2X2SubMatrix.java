package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsCols = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];
        for (int i = 0; i < rowsCols[0]; i++) {
            int[] column = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = column;
        }
        int[][] matrix2X2 = new int[2][2];
        int maxSum = Integer.MIN_VALUE;
        int[][] matrix2X2MaxSum = new int[2][2];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                matrix2X2[0][0] = matrix[i][j];
                matrix2X2[0][1] = matrix[i][j + 1];
                matrix2X2[1][0] = matrix[i + 1][j];
                matrix2X2[1][1] = matrix[i + 1][j + 1];
                int sum = 0;
                sum += matrix2X2[0][0] + matrix2X2[0][1] + matrix2X2[1][0] + matrix2X2[1][1];
                if (sum > maxSum) {
                    maxSum = sum;
                    matrix2X2MaxSum[0][0] = matrix2X2[0][0];
                    matrix2X2MaxSum[0][1] = matrix2X2[0][1];
                    matrix2X2MaxSum[1][0] = matrix2X2[1][0];
                    matrix2X2MaxSum[1][1] = matrix2X2[1][1];
                }
            }
        }
        System.out.println(matrix2X2MaxSum[0][0] + " " + matrix2X2MaxSum[0][1]);
        System.out.println(matrix2X2MaxSum[1][0] + " " + matrix2X2MaxSum[1][1]);
        System.out.println(maxSum);
    }
}
