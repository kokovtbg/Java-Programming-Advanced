package MultidimensionalArrays.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        char[][] helpMatrix = new char[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int numberI = i;
                int numberJ = j;
                boolean haveToPrint = true;
                if (j > 0) {
                    while (numberJ <= cols - 1) {
                        if (helpMatrix[numberI][numberJ] != 'c') {
                            writer.write(matrix[numberI][numberJ] + " ");
                            helpMatrix[numberI][numberJ] = 'c';
                        } else {
                            haveToPrint = false;
                        }
                        if (numberI - 1 >= 0) {
                            numberI--;
                        } else {
                            break;
                        }
                        numberJ++;
                    }
                } else {
                    while (numberI >= 0) {
                        if (helpMatrix[numberI][numberJ] != 'c') {
                            writer.write(matrix[numberI][numberJ] + " ");
                            helpMatrix[numberI][numberJ] = 'c';
                        } else {
                            haveToPrint = false;
                        }
                        if (numberJ + 1 <= cols - 1) {
                            numberJ++;
                        } else {
                            break;
                        }
                        numberI--;
                    }
                }
                if (haveToPrint) {
                    writer.write("\n");
                }
            }
        }
        writer.flush();
    }
}
