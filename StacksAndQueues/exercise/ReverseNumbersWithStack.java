package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbersReversed = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersReversed.push(numbers[i]);
        }
        while (numbersReversed.size() > 0) {
            System.out.print(numbersReversed.pop() + " ");
        }
    }
}
