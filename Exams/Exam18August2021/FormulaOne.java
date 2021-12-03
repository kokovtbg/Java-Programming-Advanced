package Exams.Exam18August2021;

import java.util.Scanner;

public class FormulaOne {
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
                if (matrix[i][j] == 'P') {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
        boolean winGame = false;
        for (int i = 0; i < countCommands; i++) {
            String command = scan.nextLine();
            int rowBeforeMovement = currentRow;
            int colBeforeMovement = currentCol;
            if (command.equals("up")) {
                rowBeforeMovement--;
                if (rowBeforeMovement < 0) {
                    rowBeforeMovement = n - 1;
                }
                if (matrix[rowBeforeMovement][colBeforeMovement] == 'B') {
                    rowBeforeMovement--;
                    if (rowBeforeMovement < 0) {
                        rowBeforeMovement = n - 1;
                    }
                    if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                        winGame = true;
                        matrix[currentRow][currentCol] = '.';
                        matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                        break;
                    }
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'T') {
                    rowBeforeMovement++;
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                    matrix[currentRow][currentCol] = '.';
                    matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                    winGame = true;
                    break;
                }
            } else if (command.equals("down")) {
                rowBeforeMovement++;
                if (rowBeforeMovement == n) {
                    rowBeforeMovement = 0;
                }
                if (matrix[rowBeforeMovement][colBeforeMovement] == 'B') {
                    rowBeforeMovement++;
                    if (rowBeforeMovement == n) {
                        rowBeforeMovement = 0;
                    }
                    if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                        winGame = true;
                        matrix[currentRow][currentCol] = '.';
                        matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                        break;
                    }
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'T') {
                    rowBeforeMovement--;
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                    winGame = true;
                    matrix[currentRow][currentCol] = '.';
                    matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                    break;
                }
            } else if (command.equals("left")) {
                colBeforeMovement--;
                if (colBeforeMovement < 0) {
                    colBeforeMovement = n - 1;
                }
                if (matrix[rowBeforeMovement][colBeforeMovement] == 'B') {
                    colBeforeMovement--;
                    if (colBeforeMovement < 0) {
                        colBeforeMovement = n - 1;
                    }
                    if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                        winGame = true;
                        matrix[currentRow][currentCol] = '.';
                        matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                        break;
                    }
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'T') {
                    colBeforeMovement++;
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                    winGame = true;
                    matrix[currentRow][currentCol] = '.';
                    matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                    break;
                }
            } else if (command.equals("right")) {
                colBeforeMovement++;
                if (colBeforeMovement == n) {
                    colBeforeMovement = 0;
                }
                if (matrix[rowBeforeMovement][colBeforeMovement] == 'B') {
                    colBeforeMovement++;
                    if (colBeforeMovement == n) {
                        colBeforeMovement = 0;
                    }
                    if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                        winGame = true;
                        matrix[currentRow][currentCol] = '.';
                        matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                        break;
                    }
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'T') {
                    colBeforeMovement--;
                } else if (matrix[rowBeforeMovement][colBeforeMovement] == 'F') {
                    winGame = true;
                    matrix[currentRow][currentCol] = '.';
                    matrix[rowBeforeMovement][colBeforeMovement] = 'P';
                    break;
                }
            }
            matrix[currentRow][currentCol] = '.';
            matrix[rowBeforeMovement][colBeforeMovement] = 'P';
            currentRow = rowBeforeMovement;
            currentCol = colBeforeMovement;
        }
        if (winGame) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.printf("Oh no, the player got lost on the track!%n");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
