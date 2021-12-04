package Generics.exercise.Threeuple1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstLine = scan.nextLine();
        String[] splitFirstLine = firstLine.split("\\s+");
        String firstnameLastname = splitFirstLine[0] + " " + splitFirstLine[1];
        String address = splitFirstLine[2];
        String town = splitFirstLine[3];
        List<Threeuple> list = new ArrayList<>();
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(firstnameLastname, address, town);
        list.add(firstThreeuple);
        String secondLine = scan.nextLine();
        String[] splitSecondLine = secondLine.split("\\s+");
        String name = splitSecondLine[0];
        int litters = Integer.parseInt(splitSecondLine[1]);
        boolean drunkNot = false;
        if (splitSecondLine[2].equals("drunk")) {
            drunkNot = true;
        }
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(name, litters, drunkNot);
        list.add(secondThreeuple);
        String thirdLine = scan.nextLine();
        String[] splitThirdLine = thirdLine.split("\\s+");
        String firstname = splitThirdLine[0];
        double account = Double.parseDouble(splitThirdLine[1]);
        String nameBank = splitThirdLine[2];
        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(firstname, account, nameBank);
        list.add(thirdThreeuple);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
