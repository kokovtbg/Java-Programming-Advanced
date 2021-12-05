package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstMatrixRowsCols = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowsFirst = firstMatrixRowsCols[0];
        int colsFirst = firstMatrixRowsCols[1];
        int[][] firstMatrix = new int[rowsFirst][colsFirst];
        for (int i = 0; i < rowsFirst; i++) {
            int[] column = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < colsFirst; j++) {
                firstMatrix[i][j] = column[j];
            }
        }
        int[] secondMatrixRowsCols = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowsSecond = secondMatrixRowsCols[0];
        int colsSecond = secondMatrixRowsCols[1];
        int[][] secondMatrix = new int[rowsSecond][colsSecond];
        for (int i = 0; i < rowsSecond; i++) {
            int[] column = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < colsSecond; j++) {
                secondMatrix[i][j] = column[j];
            }
        }
        boolean equal = true;
        if (rowsFirst != rowsSecond || colsFirst != colsSecond) {
            equal = false;
        } else {
            for (int i = 0; i < rowsFirst; i++) {
                for (int j = 0; j < colsFirst; j++) {
                    if (firstMatrix[i][j] != secondMatrix[i][j]) {
                        equal = false;
                        break;
                    }
                }
            }
        }
        if (equal) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
