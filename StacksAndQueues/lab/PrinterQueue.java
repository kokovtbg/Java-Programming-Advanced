package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                queue.offer(input);
            } else {
                if (queue.size() > 0) {
                    System.out.printf("Canceled %s%n", queue.peek());
                    queue.remove();
                } else {
                    System.out.printf("Printer is on standby%n");
                }
            }

            input = scan.nextLine();
        }
        while (queue.size() > 0) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
