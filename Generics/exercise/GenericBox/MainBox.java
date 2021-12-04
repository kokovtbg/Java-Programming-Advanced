package Generics.exercise.GenericBox;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainBox {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            Box box = new Box(line);
            writer.write(box + "");
            writer.newLine();
        }
        writer.flush();
    }
}
