package IteratorsComparatos.exercise.Froggy1;

import java.util.*;

public class MainFroggy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();
        List<Integer> evenIndexNumbers = new ArrayList<>();
        List<Integer> oddIndexNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                evenIndexNumbers.add(numbers[i]);
            } else {
                oddIndexNumbers.add(numbers[i]);
            }
        }
        List<Integer> numbersList = new ArrayList<>(evenIndexNumbers);
        numbersList.addAll(oddIndexNumbers);
        System.out.print(String.join(", ", numbersList.toString().replace("[", "").replace("]", "")));
    }
}
