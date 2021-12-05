package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class DiagonalDifference1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(scan, n, matrix);
        int sumPrimary = getSumPrimaryDiagonal(matrix);
        int sumSecondary = getSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumPrimary - sumSecondary));;

    }

    private static int getSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == matrix.length - i - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scan, int n, int[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
    }
}
