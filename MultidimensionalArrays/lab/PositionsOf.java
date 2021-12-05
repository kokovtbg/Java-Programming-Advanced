package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsCols = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];
        for (int i = 0; i < rowsCols[0]; i++) {
            int[] column = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = column;
        }
        int number = Integer.parseInt(scan.nextLine());
        boolean hasNumber = false;
        for (int i = 0; i < rowsCols[0]; i++) {
            for (int j = 0; j < rowsCols[1]; j++) {
                if (matrix[i][j] == number) {
                    System.out.printf("%d %d%n", i, j);
                    hasNumber = true;
                }
            }
        }
        if (!hasNumber) {
            System.out.println("not found");
        }
    }
}
