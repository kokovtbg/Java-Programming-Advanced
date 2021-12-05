package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsCols = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsCols[0];
        int cols = rowsCols[1];

        int currentRow = 0;
        for (int i = 97; i <= 96 + rows; i++) {
            for (int j = 97 + currentRow; j <= 96 + cols + currentRow; j++) {
                System.out.printf("%c%c%c ", (char) i, (char) j, (char) i);
            }
            currentRow++;
            System.out.println();
        }
    }
}
