package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        fibonacci.add(1L);
        long number = 0;
        while (n > 0) {
            fibonacci.add(number + fibonacci.peek());
            number = fibonacci.pop();

            n--;
        }
        System.out.println(fibonacci.peek());
    }
}
