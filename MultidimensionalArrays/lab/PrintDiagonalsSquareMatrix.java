package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] column = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = column;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.printf("%d ", matrix[i][j]);
                }
            }
        }
        System.out.println();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            for (int j = 0; j < n; j++) {
                if (i == n - count && j == count - 1) {
                    System.out.printf("%d ", matrix[i][j]);
                }
            }
        }
    }
}
