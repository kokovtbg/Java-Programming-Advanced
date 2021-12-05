package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class MatrixShuffling1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dimensions = scan.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];
        fillMatrix(scan, matrix, rows);

        String command = scan.nextLine();
        while (!command.equals("END")) {
            if (!validateCommand(command, rows, cols)) {
                System.out.printf("Invalid input!%n");
            } else {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);
                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;
                printMatrix(matrix, rows, cols);
            }

            command = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        if (commandParts.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }

    private static void fillMatrix(Scanner scan, String[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
    }
}
