package Exams.Exam20February2021;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",");
        char[][] matrix = new char[n][n];
        int countBombs = 0;
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            String data = scan.nextLine();
            int count = 0;
            for (int j = 0; j < data.length(); j++) {
                if (j % 2 == 0) {
                    char symbol = data.charAt(j);
                    matrix[i][count] = symbol;
                    if (symbol == 'B') {
                        countBombs++;
                    }
                    if (symbol == 's') {
                        currentRow = i;
                        currentCol = count;
                    }
                    count++;
                }
            }
        }
        boolean reachedEnd = false;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    currentRow = 0;
                }
            } else if (commands[i].equals("down")) {
                currentRow++;
                if (currentRow == n) {
                    currentRow = n - 1;
                }
            } else if (commands[i].equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    currentCol = 0;
                }
            } else if (commands[i].equals("right")) {
                currentCol++;
                if (currentCol == n) {
                    currentCol = n - 1;
                }
            }
            if (matrix[currentRow][currentCol] == 'B') {
                System.out.println("You found a bomb!");
                matrix[currentRow][currentCol] = '+';
                countBombs--;
                if (countBombs == 0) {
                    break;
                }
            } else if (matrix[currentRow][currentCol] == 'e') {
                reachedEnd = true;
                break;
            }
        }
        if (countBombs == 0) {
            System.out.printf("Congratulations! You found all bombs!%n");
        } else if (reachedEnd) {
            System.out.printf("END! %d bombs left on the field%n", countBombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBombs, currentRow, currentCol);
        }
    }
}
