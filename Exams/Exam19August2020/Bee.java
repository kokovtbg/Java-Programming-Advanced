package Exams.Exam19August2020;

import java.util.Scanner;

public class Bee {
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
                if (matrix[i][j] == 'B') {
                    currentRow = i;
                    currentCol = j;
                    matrix[i][j] = '.';
                }
            }
        }
        boolean beeGotLost = false;
        int flowers = 0;
        String command = scan.nextLine();
        while (!command.equals("End")) {
            if (command.equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    beeGotLost = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'O') {
                    matrix[currentRow][currentCol] = '.';
                    currentRow--;
                }
                if (currentRow < 0) {
                    beeGotLost = true;
                    break;
                }
            } else if (command.equals("down")) {
                currentRow++;
                if (currentRow >= n) {
                    beeGotLost = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'O') {
                    matrix[currentRow][currentCol] = '.';
                    currentRow++;
                }
                if (currentRow >= n) {
                    beeGotLost = true;
                    break;
                }
            } else if (command.equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    beeGotLost = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'O') {
                    matrix[currentRow][currentCol] = '.';
                    currentCol--;
                }
                if (currentCol < 0) {
                    beeGotLost = true;
                    break;
                }
            } else if (command.equals("right")) {
                currentCol++;
                if (currentCol >= n) {
                    beeGotLost = true;
                    break;
                }
                if (matrix[currentRow][currentCol] == 'O') {
                    matrix[currentRow][currentCol] = '.';
                    currentCol++;
                }
                if (currentCol >= n) {
                    beeGotLost = true;
                    break;
                }
            }
            if (matrix[currentRow][currentCol] == 'f') {
                flowers++;
                matrix[currentRow][currentCol] = '.';
            }

            command = scan.nextLine();
        }
        if (currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n) {
            matrix[currentRow][currentCol] = 'B';
        }
        if (beeGotLost) {
            System.out.printf("The bee got lost!%n");
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
