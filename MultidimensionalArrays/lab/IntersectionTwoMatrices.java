package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        String[][] firstMatrix = new String[m][n];
        String[][] secondMatrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            firstMatrix[i] = scan.nextLine().split("\\s+");
        }
        for (int i = 0; i < m; i++) {
            secondMatrix[i] = scan.nextLine().split("\\s+");
        }
        String[][] thirdMatrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    thirdMatrix[i][j] = firstMatrix[i][j];
                } else {
                    thirdMatrix[i][j] = "*";
                }
                System.out.printf("%s ", thirdMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
