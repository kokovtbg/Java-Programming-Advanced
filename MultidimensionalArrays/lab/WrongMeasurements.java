package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
// 10
// 1 1 1 1 1 1 1 1 1 1
// 0 0
        int rowElement = dimensions[0];
        int colElement = dimensions[1];
        int number = matrix[rowElement][colElement];
        int[][] secondMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                secondMatrix[i][j] = matrix[i][j];
                if (matrix[i][j] == number) {
                    matrix[i][j] = 0;
                }
            }
        }
        int[][] matrixNew = new int[rows][matrix[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i == 0 && j == 0 && i != matrix.length - 1 && j != matrix[0].length - 1) {
                    matrixNew[i][j] += matrix[i + 1][j] + matrix[i][j + 1];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i == 0 && j == matrix[0].length - 1 && i != matrix.length - 1 && j != 0) {
                    matrixNew[i][j] += matrix[i + 1][j] + matrix[i][j - 1];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i == rows - 1 && j == 0 && i != 0 && j != matrix[0].length - 1) {
                    matrixNew[i][j] += matrix[i - 1][j] + matrix[i][j + 1];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i == rows - 1 && j == matrix[0].length - 1 && i != 0 && j != 0) {
                    matrixNew[i][j] += matrix[i - 1][j] + matrix[i][j - 1];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i == 0 && j < matrix[0].length - 1 && i != matrix.length - 1) {
                    matrixNew[i][j] += matrix[i][j - 1] + matrix[i][j + 1] + matrix[i + 1][j];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i == rows - 1 && j < matrix[0].length - 1 && i != 0 && j != 0) {
                    matrixNew[i][j] += matrix[i][j - 1] + matrix[i][j + 1] + matrix[i - 1][j];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i < rows - 1 && j == 0 && i != 0 && j != matrix[0].length - 1) {
                    matrixNew[i][j] += matrix[i - 1][j] + matrix[i + 1][j] + matrix[i][j + 1];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i < rows - 1 && j == matrix[0].length - 1 && i != 0 && i != matrix.length - 1 && j != 0) {
                    matrixNew[i][j] += matrix[i][j - 1] + matrix[i - 1][j] + matrix[i + 1][j];
                } else if (matrix[i][j] == 0 && secondMatrix[i][j] == number && i != 0 && i != matrix.length - 1 && j != 0 && j != matrix[0].length - 1) {
                    matrixNew[i][j] += matrix[i][j - 1] + matrix[i][j + 1] + matrix[i - 1][j] + matrix[i + 1][j];
                } else {
                    matrixNew[i][j] = matrix[i][j];
                }
                System.out.printf("%d ", matrixNew[i][j]);
            }
            System.out.println();
        }
    }
}
