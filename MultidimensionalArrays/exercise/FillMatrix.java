package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(", ");
        int n = Integer.parseInt(data[0]);

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = i + 1;
        }
        if (data[1].equals("A")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != 1 && j != 0) {
                        matrix[i][j] = matrix[i][j - 1] + n;
                    }
                    System.out.printf("%d ", matrix[i][j]);
                }
                System.out.println();
            }
        } else if (data[1].equals("B")) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 != 0) {
                        for (int k = n - 1; k >= 0; k--) {
                            if (k == n - 1) {
                                column[k] = matrix[k][j - 1] + 1;
                            } else {
                                column[k] = column[k + 1] + 1;
                            }
                        }
                        for (int k = 0; k < n; k++) {
                            matrix[k][j] = column[k];
                        }
                    } else if (j != 0) {
                        for (int k = 0; k < n; k++) {
                            if (k == 0) {
                                column[k] = matrix[k][j - 1] + 1;
                            } else {
                                column[k] = column[k - 1] + 1;
                            }
                        }
                        for (int k = 0; k < n; k++) {
                            matrix[k][j] = column[k];
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
