package MultidimensionalArrays.lab;

import java.util.Scanner;

public class FindRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] chess = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] row = (scan.nextLine().split(" "));
            chess[i] = row;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[i][j].equals("q")) {
                    boolean hasFreeQueen = true;
                    for (int k = 0; k < 8; k++) {
                        if (chess[i][k].equals("q") && k != j) {
                            hasFreeQueen = false;
                            break;
                        }
                    }
                    for (int k = 0; k < 8; k++) {
                        if (chess[k][j].equals("q") && k != i) {
                            hasFreeQueen = false;
                            break;
                        }
                    }
                    if (i < 7 && j < 7) {
                        int indexRow = i + 1;
                        int indexCol = j + 1;
                        while (indexRow < 8 && indexCol < 8) {
                            String element = chess[indexRow][indexCol];
                            if (element.equals("q")) {
                                hasFreeQueen = false;
                                break;
                            }
                            indexRow++;
                            indexCol++;
                        }
                    }
                    if (i > 0 && j > 0) {
                        int indexRow = i - 1;
                        int indexCol = j - 1;
                        while (indexRow > 0 && indexCol > 0) {
                            String element = chess[indexRow][indexCol];
                            if (element.equals("q")) {
                                hasFreeQueen = false;
                                break;
                            }
                            indexRow--;
                            indexCol--;
                        }
                    }
                    if (i > 0 && j < 7) {
                        int indexRow = i - 1;
                        int indexCol = j + 1;
                        while (indexRow > 0 && indexCol < 8) {
                            String element = chess[indexRow][indexCol];
                            if (element.equals("q")) {
                                hasFreeQueen = false;
                                break;
                            }
                            indexRow--;
                            indexCol++;
                        }
                    }
                    if (i < 7 && j > 0) {
                        int indexRow = i + 1;
                        int indexCol = j - 1;
                        while (indexRow < 8 && indexCol > 0) {
                            String element = chess[indexRow][indexCol];
                            if (element.equals("q")) {
                                hasFreeQueen = false;
                                break;
                            }
                            indexRow++;
                            indexCol--;
                        }
                    }
                    if (hasFreeQueen) {
                        System.out.printf("%d %d", i, j);
                        System.out.println();
                    }
                }
            }
        }
    }
}
