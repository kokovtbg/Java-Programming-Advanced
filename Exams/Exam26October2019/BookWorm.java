package Exams.Exam26October2019;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'P') {
                    currentRow = i;
                    currentCol = j;
                    matrix[i][j] = '-';
                }
            }
        }
        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.equals("up")) {
                currentRow--;
            } else if (command.equals("down")) {
                currentRow++;
            } else if (command.equals("left")) {
                currentCol--;
            } else if (command.equals("right")) {
                currentCol++;
            }
            if (validateRowCol(n, currentRow, currentCol)) {
                if (Character.isLetter(matrix[currentRow][currentCol])) {
                    stringBuilder.append(matrix[currentRow][currentCol]);
                }
                matrix[currentRow][currentCol] = '-';
            } else {
                currentRow = returnInsideMatrixRow(n, currentRow);
                currentCol = returnInsideMatrixCol(n, currentCol);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            command = scan.nextLine();
        }
        matrix[currentRow][currentCol] = 'P';
        System.out.println(stringBuilder);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int returnInsideMatrixCol(int n, int currentCol) {
        if (currentCol < 0) {
            currentCol = 0;
        } else if (currentCol == n) {
            currentCol = n - 1;
        }
        return currentCol;
    }

    private static int returnInsideMatrixRow(int n, int currentRow) {
        if (currentRow < 0) {
            currentRow = 0;
        } else if (currentRow == n) {
            currentRow = n - 1;
        }
        return currentRow;
    }

    private static boolean validateRowCol(int n, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n;
    }
}
