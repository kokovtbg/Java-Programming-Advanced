package Generics.exercise.CustomList1;

import java.util.Scanner;

public class MainCustomListSorter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();
        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            if (data[0].equals("Add")) {
                list.add(data[1]);
            } else if (data[0].equals("Remove")) {
                list.remove(Integer.parseInt(data[1]));
            } else if (data[0].equals("Contains")) {
                System.out.println(list.contains(data[1]));
            } else if (data[0].equals("Swap")) {
                list.swap(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            } else if (data[0].equals("Greater")) {
                System.out.println(list.countGreaterThan(data[1]));
            } else if (data[0].equals("Max")) {
                System.out.println(list.getMax());
            } else if (data[0].equals("Min")) {
                System.out.println(list.getMin());
            } else if (data[0].equals("Print")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            } else if (data[0].equals("Sort")) {
                CustomListSorter.methodSort(list);
            }

            command = scan.nextLine();
        }
    }
}
