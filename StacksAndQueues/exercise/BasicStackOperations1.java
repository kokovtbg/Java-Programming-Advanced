package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();

        for (int count = 1; count <= n; count++) {
            stack.push(scan.nextInt());
        }
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {
                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }
    }
}
