package Exams.Exam26June2021;

import java.util.Arrays;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][n];
        int pythonLength = 1;
        String[] commands = scan.nextLine().split(", *");
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split(" ");
            for (int j = 0; j < splitData.length; j++) {
                matrix[i][j] = splitData[j];
            }
        }
        int currentRow = 0;
        int currentCol = 0;
        int countFood = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("s")) {
                    currentRow = i;
                    currentCol = j;
                } else if (matrix[i][j].equals("f")) {
                    countFood++;
                }
            }
        }
        boolean beaten = false;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("up")) {
                currentRow--;
                if (currentRow < 0) {
                    currentRow = n - 1;
                }
            } else if (commands[i].equals("down")) {
                currentRow++;
                if (currentRow == n) {
                    currentRow = 0;
                }
            } else if (commands[i].equals("left")) {
                currentCol--;
                if (currentCol < 0) {
                    currentCol = n - 1;
                }
            } else if (commands[i].equals("right")) {
                currentCol++;
                if (currentCol == n) {
                    currentCol = 0;
                }
            }
            if (matrix[currentRow][currentCol].equals("e")) {
                beaten = true;
                break;
            } else if (matrix[currentRow][currentCol].equals("f")) {
                pythonLength++;
                countFood--;
                if (countFood == 0) {
                    break;
                }
            }
        }
        if (countFood == 0) {
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else if (beaten) {
            System.out.printf("You lose! Killed by an enemy!%n");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }
    }
}
