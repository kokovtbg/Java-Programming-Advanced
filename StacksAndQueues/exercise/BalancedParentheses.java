package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sequence = scan.nextLine();

        ArrayDeque<Character> queue1 = new ArrayDeque<>();
        ArrayDeque<Character> queue2 = new ArrayDeque<>();

        for (int i = 0; i < sequence.length() / 2; i++) {
            queue1.add(sequence.charAt(i));
        }
        for (int i = sequence.length() - 1; i >= sequence.length() / 2; i--) {
            queue2.add(sequence.charAt(i));
        }
        while (queue1.size() > 0 && queue2.size() > 0) {
            if (queue1.peek() == '(' && queue2.peek() == ')') {
                queue1.remove();
                queue2.remove();
            } else if (queue1.peek() == '[' && queue2.peek() == ']') {
                queue1.remove();
                queue2.remove();
            } else if (queue1.peek() == '{' && queue2.peek() == '}') {
                queue1.remove();
                queue2.remove();
            } else {
                break;
            }
        }
        if (queue1.size() == 0 && queue2.size() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
