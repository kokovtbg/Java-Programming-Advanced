package FunctionalProgramming.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        int n = Integer.parseInt(scan.nextLine());
        int[] dividers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= n; i++) {
            boolean haveToPrint = true;
            for (int j = 0; j < dividers.length; j++) {
                if (i % dividers[j] != 0) {
                    haveToPrint = false;
                    break;
                }
            }
            if (haveToPrint) {
                writer.write(i + " ");
            }
        }
        writer.flush();
    }
}
