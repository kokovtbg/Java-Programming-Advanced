package StacksAndQueues.exercise;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            if (command.charAt(0) == '1') {
                int[] numbers = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                stack.push(numbers[1]);
            }
            if (command.equals("2")) {
                stack.pop();
            }
            if (command.equals("3")) {
                int maxNumber = Integer.MIN_VALUE;
                List<Integer> numbers = new ArrayList<>();
                while (stack.size() > 0) {
                    numbers.add(stack.pop());
                }
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j) > maxNumber) {
                        maxNumber = numbers.get(j);
                    }
                }
                for (int j = numbers.size() - 1; j >= 0; j--) {
                    stack.push(numbers.get(j));
                }
                System.out.println(maxNumber);
            }
        }
    }
}
