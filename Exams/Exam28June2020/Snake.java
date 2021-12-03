package Exams.Exam28June2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'S') {
                    currentRow = i;
                    currentCol = j;
                    matrix[i][j] = '.';
                }
            }
        }
        String command = scan.nextLine();
        boolean outOfTerritory = false;
        int food = 0;
        while (true) {
            if (command.equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    outOfTerritory = true;
                    break;
                }
            } else if (command.equals("down")) {
                currentRow++;
                if (currentRow == n) {
                    outOfTerritory = true;
                    break;
                }
            } else if (command.equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    outOfTerritory = true;
                    break;
                }
            } else if (command.equals("right")) {
                currentCol++;
                if (currentCol == n) {
                    outOfTerritory = true;
                    break;
                }
            }
            if (matrix[currentRow][currentCol] == 'B') {
                matrix[currentRow][currentCol] = '.';
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 'B') {
                            currentRow = i;
                            currentCol = j;
                            matrix[i][j] = '.';
                        }
                    }
                }
            } else if (matrix[currentRow][currentCol] == '*') {
                food++;
                if (food == 10) {
                    matrix[currentRow][currentCol] = 'S';
                    break;
                }
            }
            matrix[currentRow][currentCol] = '.';

            command = scan.nextLine();
        }
        if (outOfTerritory) {
            System.out.printf("Game over!%n");
        } else {
            System.out.printf("You won! You fed the snake.%n");
        }
        System.out.printf("Food eaten: %d%n", food);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
