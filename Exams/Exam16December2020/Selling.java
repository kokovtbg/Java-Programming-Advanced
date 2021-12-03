package Exams.Exam16December2020;

import java.util.Scanner;

public class Selling {
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
        matrix[currentRow][currentCol] = '-';
        int money = 0;
        boolean outOfBakery = false;
        String command = scan.nextLine();
        while (true) {
            if (command.equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    outOfBakery = true;
                    break;
                }
            } else if (command.equals("down")) {
                currentRow++;
                if (currentRow == n) {
                    outOfBakery = true;
                    break;
                }
            } else if (command.equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    outOfBakery = true;
                    break;
                }
            } else if (command.equals("right")) {
                currentCol++;
                if (currentCol == n) {
                    outOfBakery = true;
                    break;
                }
            }
            if (matrix[currentRow][currentCol] == 'O') {
                matrix[currentRow][currentCol] = '-';
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 'O') {
                            currentRow = i;
                            currentCol = j;
                            matrix[i][j] = '-';
                        }
                    }
                }
            } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                money += Integer.parseInt(matrix[currentRow][currentCol] + "");
                matrix[currentRow][currentCol] = '-';
                if (money >= 50) {
                    matrix[currentRow][currentCol] = 'S';
                    break;
                }
            }

            command = scan.nextLine();
        }
        if (outOfBakery) {
            System.out.printf("Bad news, you are out of the bakery.%n");
        } else {
            System.out.printf("Good news! You succeeded in collecting enough money!%n");
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
