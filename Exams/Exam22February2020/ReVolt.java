package Exams.Exam22February2020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'f') {
                    currentRow = i;
                    currentCol = j;
                    matrix[i][j] = '-';
                }
            }
        }
        boolean hasWon = false;
        for (int i = 0; i < countCommands; i++) {
            String command = scan.nextLine();
            if (command.equals("up")) {
                currentRow--;
                currentRow = validateRowCol(n, currentRow);
                if (matrix[currentRow][currentCol] == 'B') {
                    currentRow--;
                    currentRow = validateRowCol(n, currentRow);
                } else if (matrix[currentRow][currentCol] == 'T') {
                    currentRow++;
                    currentRow = validateRowCol(n, currentRow);
                }
            } else if (command.equals("down")) {
                currentRow++;
                currentRow = validateRowCol(n, currentRow);
                if (matrix[currentRow][currentCol] == 'B') {
                    currentRow++;
                    currentRow = validateRowCol(n, currentRow);
                } else if (matrix[currentRow][currentCol] == 'T') {
                    currentRow--;
                    currentRow = validateRowCol(n, currentRow);
                }
            } else if (command.equals("left")) {
                currentCol--;
                currentCol = validateRowCol(n, currentCol);
                if (matrix[currentRow][currentCol] == 'B') {
                    currentCol--;
                    currentCol = validateRowCol(n, currentCol);
                } else if (matrix[currentRow][currentCol] == 'T') {
                    currentCol++;
                    currentCol = validateRowCol(n, currentCol);
                }
            } else if (command.equals("right")) {
                currentCol++;
                currentCol = validateRowCol(n, currentCol);
                if (matrix[currentRow][currentCol] == 'B') {
                    currentCol++;
                    currentCol = validateRowCol(n, currentCol);
                } else if (matrix[currentRow][currentCol] == 'T') {
                    currentCol--;
                    currentCol = validateRowCol(n, currentCol);
                }
            }
            if (matrix[currentRow][currentCol] == 'F') {
                hasWon = true;
                break;
            }
        }
        matrix[currentRow][currentCol] = 'f';
        if (hasWon) {
            System.out.printf("Player won!%n");
        } else {
            System.out.printf("Player lost!%n");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int validateRowCol(int n, int currentRowOrCol) {
        if (currentRowOrCol < 0) {
            currentRowOrCol = n - 1;
        } else if (currentRowOrCol == n) {
            currentRowOrCol = 0;
        }
        return currentRowOrCol;
    }
}
