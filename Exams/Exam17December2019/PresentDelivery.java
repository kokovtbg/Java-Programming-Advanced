package Exams.Exam17December2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countPresents = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        int currentRow = 0;
        int currentCol = 0;
        int goodKids = 0;
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            int count = 0;
            for (int j = 0; j < line.length(); j++) {
                if (j % 2 == 0) {
                    matrix[i][count] = line.charAt(j);
                    if (matrix[i][count] == 'S') {
                        currentRow = i;
                        currentCol = count;
                        matrix[i][count] = '-';
                    } else if (matrix[i][count] == 'V') {
                        goodKids++;
                    }
                    count++;
                }
            }
        }
        String command = scan.nextLine();
        int happyKids = 0;
        while (!command.equals("Christmas morning")) {
            if (command.equals("up")) {
                currentRow--;
            } else if (command.equals("down")) {
                currentRow++;
            } else if (command.equals("left")) {
                currentCol--;
            } else if (command.equals("right")) {
                currentCol++;
            }
            if (matrix[currentRow][currentCol] == 'V') {
                goodKids--;
                happyKids++;
                countPresents--;
            } else if (matrix[currentRow][currentCol] == 'C') {
                if (matrix[currentRow - 1][currentCol] == 'V') {
                    goodKids--;
                    happyKids++;
                    countPresents--;
                }
                matrix[currentRow - 1][currentCol] = '-';
                if (matrix[currentRow + 1][currentCol] == 'V') {
                    goodKids--;
                    happyKids++;
                    countPresents--;
                }
                matrix[currentRow + 1][currentCol] = '-';
                if (matrix[currentRow][currentCol - 1] == 'V') {
                    goodKids--;
                    happyKids++;
                    countPresents--;
                }
                matrix[currentRow][currentCol - 1] = '-';
                if (matrix[currentRow][currentCol + 1] == 'V') {
                    goodKids--;
                    happyKids++;
                    countPresents--;
                }
                matrix[currentRow][currentCol + 1] = '-';
            }
            if (countPresents == 0) {
                break;
            }
            matrix[currentRow][currentCol] = '-';

            command = scan.nextLine();
        }
        matrix[currentRow][currentCol] = 'S';
        if (countPresents == 0) {
            System.out.printf("Santa ran out of presents!%n");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c ", matrix[i][j]);
            }
            System.out.println();
        }
        if (goodKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", happyKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", goodKids);
        }
    }
}
