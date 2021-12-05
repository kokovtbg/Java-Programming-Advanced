package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'P') {
                    currentRow = i;
                    currentCol = j;
                    matrix[i][j] = '.';
                }
            }
        }
        String commands = scan.nextLine();
        boolean gameOver = false;
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'U') {
                currentRow--;
            } else if (commands.charAt(i) == 'D') {
                currentRow++;
            } else if (commands.charAt(i) == 'L') {
                currentCol--;
            } else if (commands.charAt(i) == 'R') {
                currentCol++;
            }
            currentRow = validateRow(n, currentRow);
            currentCol = validateCol(m, currentCol);
            extractedMethodBunnies(n, m, matrix);
            if (matrix[currentRow][currentCol] == 'B') {
                gameOver = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
        if (gameOver) {
            System.out.printf("dead: %d %d", currentRow, currentCol);
        } else {
            System.out.printf("won: %d %d", currentRow, currentCol);
        }
    }

    private static void extractedMethodBunnies(int n, int m, char[][] matrix) {
        char[][] matrix2 = new char[n][m];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                matrix2[j][k] = '.';
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (matrix[j][k] == 'B') {
                    generateBunnies(matrix2, j, k);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                matrix[j][k] = matrix2[j][k];
            }
        }
    }

    public static void generateBunnies(char[][] matrix, int row, int col) {
        matrix[row][col] = 'B';
        if (row - 1 >= 0) {
            matrix[row - 1][col] = 'B';
        }
        if (row + 1 < matrix.length) {
            matrix[row + 1][col] = 'B';
        }
        if (col - 1 >= 0) {
            matrix[row][col - 1] = 'B';
        }
        if (col + 1 < matrix[0].length) {
            matrix[row][col + 1] = 'B';
        }
    }

    public static int validateRow(int rows, int currentRow) {
        if (currentRow < 0) {
            currentRow = 0;
        }
        if (currentRow == rows) {
            currentRow = rows - 1;
        }
        return currentRow;
    }

    public static int validateCol(int cols, int currentCol) {
        if (currentCol < 0) {
            currentCol = 0;
        }
        if (currentCol == cols) {
            currentCol = cols - 1;
        }
        return currentCol;
    }
}
