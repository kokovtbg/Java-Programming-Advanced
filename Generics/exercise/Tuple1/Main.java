package Generics.exercise.Tuple1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        List<Tuple> list = new ArrayList<>();
        String firstLine = scan.nextLine();
        String[] splitFirstLine = firstLine.split("\\s+");
        String firstnameLastname = splitFirstLine[0] + " " + splitFirstLine[1];
        String address = splitFirstLine[2];
        Tuple<String, String> firstTuple = new Tuple<>(firstnameLastname, address);
        list.add(firstTuple);
        String secondLine = scan.nextLine();
        String[] splitSecondLine = secondLine.split("\\s+");
        String name = splitSecondLine[0];
        int litters = Integer.parseInt(splitSecondLine[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, litters);
        list.add(secondTuple);
        String thirdLine = scan.nextLine();
        String[] splitThirdLine = thirdLine.split("\\s+");
        int number1 = Integer.parseInt(splitThirdLine[0]);
        double number2 = Double.parseDouble(splitThirdLine[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(number1, number2);
        list.add(thirdTuple);

        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i) + "");
            writer.newLine();
        }
        writer.flush();
    }
}
