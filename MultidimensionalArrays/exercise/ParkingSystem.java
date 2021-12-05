package MultidimensionalArrays.exercise;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        char[][] matrix = new char[r][c];
        String command = reader.readLine();
        while (!command.equals("stop")) {
            int[] entryRowCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = entryRowCoordinates[0];
            int x = entryRowCoordinates[1];
            int y = entryRowCoordinates[2];
            int distance = 1;
            int currentRow = entryRow;
            int currentCol;
            if (x < currentRow) {
                distance += currentRow - x;
            } else if (x > currentRow) {
                distance += x - currentRow;
            }
            currentRow = x;
            distance += y;
            currentCol = y;
            if (matrix[currentRow][currentCol] == 'p') {
                int distanceToRemove = 0;
                while (matrix[currentRow][currentCol] == 'p') {
                    currentCol--;
                    distanceToRemove++;
                }
                if (currentCol == 0) {
                    if (y < c - 1) {
                        currentCol = y + 1;
                        if (matrix[currentRow][currentCol] == 'p') {
                            while (currentCol < c && matrix[currentRow][currentCol] == 'p') {
                                currentCol++;
                                distance++;
                            }
                            if (currentCol == c) {
                                System.out.printf("Row %d full%n", x);
                                command = reader.readLine();
                                continue;
                            } else {
                                matrix[currentRow][currentCol] = 'p';
                                distance++;
                            }
                        } else {
                            matrix[currentRow][currentCol] = 'p';
                            distance++;
                        }

                    } else {
                        System.out.printf("Row %d full%n", x);
                        command = reader.readLine();
                        continue;
                    }
                } else {
                    matrix[currentRow][currentCol] = 'p';
                    distance -= distanceToRemove;
                }
            } else {
                matrix[currentRow][currentCol] = 'p';
            }
            System.out.println(distance);


            command = reader.readLine();
        }
    }
}
