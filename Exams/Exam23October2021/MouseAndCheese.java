package Exams.Exam23October2021;

import java.util.Scanner;

public class MouseAndCheese {
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
                if (matrix[i][j] == 'M') {
                    matrix[i][j] = '-';
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
        int foodEaten = 0;
        boolean outOfMatrix = false;
        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    outOfMatrix = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'B') {
                    matrix[currentRow][currentCol] = '-';
                    currentRow--;
                    if (currentRow < 0) {
                        outOfMatrix = true;
                        break;
                    }
                }
            } else if (command.equals("down")) {
                currentRow++;
                if (currentRow == n) {
                    outOfMatrix = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'B') {
                    matrix[currentRow][currentCol] = '-';
                    currentRow++;
                    if (currentRow == n) {
                        outOfMatrix = true;
                        break;
                    }
                }
            } else if (command.equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    outOfMatrix = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'B') {
                    matrix[currentRow][currentCol] = '-';
                    currentCol--;
                    if (currentCol < 0) {
                        outOfMatrix = true;
                        break;
                    }
                }
            } else if (command.equals("right")) {
                currentCol++;
                if (currentCol == n) {
                    outOfMatrix= true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'B') {
                    matrix[currentRow][currentCol] = '-';
                    currentCol++;
                    if (currentCol == n) {
                        outOfMatrix = true;
                        break;
                    }
                }
            }
            if (matrix[currentRow][currentCol] == 'c') {
                foodEaten++;
            }
            matrix[currentRow][currentCol] = '-';

            command = scan.nextLine();
        }
        if (!outOfMatrix) {
            matrix[currentRow][currentCol] = 'M';
        }
        if (outOfMatrix) {
            System.out.println("Where is the mouse?");
        }
        if (foodEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", foodEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - foodEaten);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
