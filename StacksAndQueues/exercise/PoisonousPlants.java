package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Integer> plants = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        if (plants.size() > n) {
            while (plants.size() > n) {
                plants.remove(n - 1);
            }
        }
        int countDays = 1;
        ArrayDeque<Integer> indexPlantsToRemove = new ArrayDeque<>();
        while (true) {
            for (int i = 0; i < plants.size(); i++) {
                if (i > 0 && plants.get(i) > plants.get(i - 1)) {
                    indexPlantsToRemove.push(i);
                }
            }
            while (indexPlantsToRemove.size() > 0) {
                int indexToRemove = indexPlantsToRemove.peek();
                plants.remove(indexToRemove);
                indexPlantsToRemove.pop();
            }
            boolean plantLeftBigger = true;
            for (int i = 0; i < plants.size(); i++) {
                if (i > 0 && plants.get(i) > plants.get(i - 1)) {
                    plantLeftBigger = false;
                    break;
                }
            }
            if (plantLeftBigger) {
                break;
            }
            countDays++;

        }
        System.out.println(countDays);
    }
}
