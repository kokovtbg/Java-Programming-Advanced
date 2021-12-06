package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nSX = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = nSX[0];
        int s = nSX[1];
        int x = nSX[2];
        while (n > 0) {
            stack.push(numbers.get(0));
            numbers.remove(0);
            n--;
        }
        while (s > 0) {
            stack.pop();
            s--;
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else if (stack.size() > 0) {
            int minNumber = Integer.MAX_VALUE;
            while (stack.size() > 0) {
                int number = stack.pop();
                if (number < minNumber) {
                    minNumber = number;
                }
            }
            System.out.println(minNumber);
        } else {
            System.out.println("0");
        }
    }
}
