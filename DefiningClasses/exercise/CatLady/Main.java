package DefiningClasses.exercise.CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Cat> cats = new ArrayList<>();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double characteristic = Double.parseDouble(data[2]);
            Cat cat = new Cat(breed, name, characteristic);
            cats.add(cat);

            input = scan.nextLine();
        }
        String name = scan.nextLine();
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getName().equals(name)) {
                System.out.println(cats.get(i));
            }
        }
    }
}
