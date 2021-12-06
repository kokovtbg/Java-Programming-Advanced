package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle > 1) {
            int count = 0;
            for (int i = 1; i <= cycle; i++) {
                if (cycle % i == 0) {
                    count++;
                }
            }
            return count == 2;
        } else {
            return false;
        }
    }
}
