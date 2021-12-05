package MultidimensionalArrays.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrixToManipulate = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    matrixToManipulate[i][j] = j + 1;
                } else {
                    matrixToManipulate[i][j] = matrixToManipulate[i - 1][matrixToManipulate[0].length - 1] + j + 1;
                }
            }
        }

        String command = scan.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] commandData = command.split("\\s+");
            int row = Integer.parseInt(commandData[0]);
            int col = Integer.parseInt(commandData[1]);
            int radius = Integer.parseInt(commandData[2]);

            for (int i = col - radius; i <= col + radius; i++) {
                if (i >= 0 && i < cols && row >= 0 && row < matrixToManipulate.length) {
                    matrixToManipulate[row][i] = 0;
                }
            }
            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < matrixToManipulate.length && col >= 0 && col < cols) {
                    matrixToManipulate[i][col] = 0;
                }
            }
            for (int i = 0; i < matrixToManipulate.length; i++) {
                for (int j = 0; j < matrixToManipulate[i].length; j++) {
                    if (j < matrixToManipulate[i].length - 1 && matrixToManipulate[i][j] == 0) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = j + 1; k < matrixToManipulate[i].length; k++) {
                            list.add(matrixToManipulate[i][k]);
                        }
                        while (list.size() > 0) {
                            matrixToManipulate[i][j] = list.get(0);
                            list.remove(0);
                            j++;
                        }
                        matrixToManipulate[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < matrixToManipulate.length - 1; i++) {
                boolean emptyRow = true;
                for (int j = 0; j < cols; j++) {
                    if (matrixToManipulate[i][j] != 0) {
                        emptyRow = false;
                        break;
                    }
                }
                if (emptyRow) {
                    for (int j = 0; j < cols; j++) {
                        matrixToManipulate[i][j] = matrixToManipulate[i + 1][j];
                        matrixToManipulate[i + 1][j] = 0;
                    }
                }
            }
            boolean emptyRow = true;
            for (int i = 0; i < cols; i++) {
                if (matrixToManipulate[matrixToManipulate.length - 1][i] != 0) {
                    emptyRow = false;
                    break;
                }
            }
            if (emptyRow) {
                int[][] matrixNew = new int[matrixToManipulate.length - 1][cols];
                for (int j = 0; j < matrixToManipulate.length - 1; j++) {
                    matrixNew[j] = matrixToManipulate[j];
                }
                matrixToManipulate = new int[matrixToManipulate.length - 1][cols];
                for (int j = 0; j < matrixToManipulate.length; j++) {
                    matrixToManipulate[j] = matrixNew[j];
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < matrixToManipulate.length; i++) {
            for (int j = 0; j < matrixToManipulate[i].length; j++) {
                if (matrixToManipulate[i][j] != 0) {
                    writer.write(matrixToManipulate[i][j] + " ");
//                    System.out.printf("%d ", matrixToManipulate[i][j]);
                }
            }
            writer.newLine();
//            System.out.println();
        }
        writer.flush();
    }
}
