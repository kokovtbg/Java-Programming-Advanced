package Exams.Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersTasks = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersThreads = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int taskToBeKilled = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        for (int i = 0; i < numbersTasks.length; i++) {
            tasks.push(numbersTasks[i]);
        }
        for (int i = 0; i < numbersThreads.length; i++) {
            threads.offer(numbersThreads[i]);
        }
        while (!threads.isEmpty() && !tasks.isEmpty()) {
            if (threads.peek() >= tasks.peek() && tasks.peek() != taskToBeKilled) {
                tasks.pop();
                threads.poll();
            } else if (threads.peek() < tasks.peek() && tasks.peek() != taskToBeKilled) {
                threads.poll();
            } else if (tasks.peek() == taskToBeKilled) {
                System.out.printf("Thread with value %d killed task %d%n", threads.peek(), taskToBeKilled);
                break;
            }
        }
        while (!threads.isEmpty()) {
            System.out.printf("%d ", threads.poll());
        }
    }
}
