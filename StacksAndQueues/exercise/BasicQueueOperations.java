package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nSX = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n = nSX[0];
        int s = nSX[1];
        int x = nSX[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (n > 0) {
            queue.add(numbers.get(0));
            numbers.remove(0);
            n--;
        }
        while (s > 0) {
            queue.remove();
            s--;
        }
        if (queue.contains(x)) {
            System.out.println("true");
        } else if (queue.size() > 0) {
            int minNumber = Integer.MAX_VALUE;
            while (queue.size() > 0) {
                int number = queue.pop();
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
