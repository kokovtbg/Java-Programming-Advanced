package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double damageHeigan = Double.parseDouble(scan.nextLine());

        char[][] matrix = new char[15][15];
        int currentPositionRow = 7;
        int currentPositionCol = 7;
        int health = 18500;
        double healthHeigan = 3000000;
        String currentSpell = "";
        String command = scan.nextLine();
        while (healthHeigan > 0) {
            String[] commandData = command.split("\\s+");
            String spell = commandData[0];
            int row = Integer.parseInt(commandData[1]);
            int col = Integer.parseInt(commandData[2]);
            if (row >= 0 && row < 15 && col >= 0 && col < 15) {
                matrix[row][col] = 'c';
            }
            healthHeigan -= damageHeigan;
            if (healthHeigan <= 0) {
                break;
            }
            if (currentSpell.equals("Plague Cloud")) {
                health -= 3500;
                currentSpell = "";
                if (health <= 0) {
                    break;
                }
            }
            if (row + 1 < 15 && col >= 0 && col < 15) {
                matrix[row + 1][col] = 'c';
            }
            if (row - 1 >= 0 && col >= 0 && col < 15) {
                matrix[row - 1][col] = 'c';
            }
            if (col + 1 < 15 && row >= 0 && row < 15) {
                matrix[row][col + 1] = 'c';
            }
            if (col - 1 >= 0 && row >= 0 && row < 15) {
                matrix[row][col - 1] = 'c';
            }
            if (row + 1 < 15 && col - 1 >= 0) {
                matrix[row + 1][col - 1] = 'c';
            }
            if (row + 1 < 15 && col + 1 < 15) {
                matrix[row + 1][col + 1] = 'c';
            }
            if (row - 1 >= 0 && col - 1 >= 0) {
                matrix[row - 1][col - 1] = 'c';
            }
            if (row - 1 >= 0 && col + 1 < 15) {
                matrix[row - 1][col + 1] = 'c';
            }
            if (matrix[currentPositionRow][currentPositionCol] == 'c') {
                if (currentPositionRow - 1 >= 0 && matrix[currentPositionRow - 1][currentPositionCol] != 'c') {
                    currentPositionRow--;
                } else if (currentPositionCol + 1 < 15 && matrix[currentPositionRow][currentPositionCol + 1] != 'c') {
                    currentPositionCol++;
                } else if (currentPositionRow + 1 < 15 && matrix[currentPositionRow + 1][currentPositionCol] != 'c') {
                    currentPositionRow++;
                } else if (currentPositionCol - 1 >= 0 && matrix[currentPositionRow][currentPositionCol - 1] != 'c') {
                    currentPositionCol--;
                }
            }
            if (spell.equals("Cloud")) {
                if (matrix[currentPositionRow][currentPositionCol] == 'c') {
                    currentSpell = "Plague Cloud";
                    health -= 3500;
                }
            } else if (spell.equals("Eruption")) {
                if (matrix[currentPositionRow][currentPositionCol] == 'c') {
                    currentSpell = "Eruption";
                    health -= 6000;
                }
            }
            matrix = new char[15][15];
            if (health <= 0) {
                break;
            }

            command = scan.nextLine();
        }
        if (healthHeigan <= 0) {
            System.out.printf("Heigan: Defeated!%n");
            System.out.printf("Player: %d%n", health);
            System.out.printf("Final position: %d, %d", currentPositionRow, currentPositionCol);
        } else if (health <= 0) {
            System.out.printf("Heigan: %.2f%n", healthHeigan);
            System.out.printf("Player: Killed by %s%n", currentSpell);
            System.out.printf("Final position: %d, %d", currentPositionRow, currentPositionCol);
        }
    }
}
