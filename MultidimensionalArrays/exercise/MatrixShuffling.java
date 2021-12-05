package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] commandData = command.split("\\s+");
            if (commandData[0].equals("swap") && commandData.length == 5) {
                int firstElementRow = Integer.parseInt(commandData[1]);
                int firstElementCol = Integer.parseInt(commandData[2]);
                int secondElementRow = Integer.parseInt(commandData[3]);
                int secondElementCol = Integer.parseInt(commandData[4]);
                if (firstElementRow >= 0 && firstElementRow < matrix.length && firstElementCol >= 0 && firstElementCol < matrix[0].length && secondElementRow >= 0 && secondElementRow < matrix.length && secondElementCol >= 0 && secondElementCol < matrix[0].length) {
                    String firstElement = matrix[firstElementRow][firstElementCol];
                    matrix[firstElementRow][firstElementCol] = matrix[secondElementRow][secondElementCol];
                    matrix[secondElementRow][secondElementCol] = firstElement;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.printf("%s ", matrix[i][j]);
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scan.nextLine();
        }
    }
}
