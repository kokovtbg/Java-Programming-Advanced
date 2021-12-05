package MultidimensionalArrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ParkingSystem1 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] parking = new int[rows][cols];

        while (true) {
            String input = reader.readLine();
            if (input.equals("stop")) break;
            String[] command = input.split(" ");

            int z = Integer.parseInt(command[0]);
            int x = Integer.parseInt(command[1]);
            int y = Integer.parseInt(command[2]);

            int moves = 0;
            boolean found = false;

            if (parking[x][y] == 0) {
                moves = findMoves(z, x, y);
                parking[x][y] = 1;
                found = true;
            } else {
                int range = 1;
                while (!found) {
                    if (y - range >= 1 && parking[x][y - range] == 0) {
                        moves = findMoves(z, x, y - range);
                        found = true;
                        parking[x][y - range] = 1;
                    } else if (y + range < parking[x].length && parking[x][y + range] == 0) {
                        moves = findMoves(z, x, y + range);
                        found = true;
                        parking[x][y + range] = 1;
                    }
                    if (y - range < 1 && y + range >= parking[x].length) {
                        System.out.printf("Row %d full%n", x);
                        break;
                    }
                    range++;
                }
            }
            if (found) System.out.println(moves);
        }
    }

    private static int findMoves(int z, int x, int y) {
        return Math.abs(z - x) + y + 1;
    }
}
