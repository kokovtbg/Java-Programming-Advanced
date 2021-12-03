package Exams.Exam14April2021;

import java.util.Scanner;

public class CookingJourney {
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
                }
            }
        }
        int money = 0;
        matrix[currentRow][currentCol] = '-';
        String command = scan.nextLine();
        while (money < 50) {
            if (command.equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    break;
                }
            } else if (command.equals("down")) {
                currentRow++;
                if (currentRow == n) {
                    break;
                }
            } else if (command.equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    break;
                }
            } else if (command.equals("right")) {
                currentCol++;
                if (currentCol == n) {
                    break;
                }
            }
            if (matrix[currentRow][currentCol] == 'P') {
                matrix[currentRow][currentCol] = '-';
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 'P') {
                            matrix[i][j] = '-';
                            currentRow = i;
                            currentCol = j;
                        }
                    }
                }
            } else if (matrix[currentRow][currentCol] >= '0' && matrix[currentRow][currentCol] <= '9') {
                money += Integer.parseInt(matrix[currentRow][currentCol] + "");
                matrix[currentRow][currentCol] = '-';
                if (money >= 50) {
                    break;
                }
            }
            command = scan.nextLine();
        }
        if (money >= 50) {
            matrix[currentRow][currentCol] = 'S';
            System.out.printf("Good news! You succeeded in collecting enough money!%n");
        } else {
            System.out.printf("Bad news! You are out of the pastry shop.%n");
        }
        System.out.printf("Money: %d%n", money);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
