package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] expression = scan.nextLine().split(" ");

        ArrayDeque<String> operators = new ArrayDeque<>();
        for (int i = 0; i < expression.length; i++) {
            if (Character.isLetterOrDigit(expression[i].charAt(0))) {
                System.out.print(expression[i] + " ");
            } else {
                if (operators.size() != 0) {
                    if ((expression[i].equals("+") && operators.peek().equals("+")) || (expression[i].equals("-") && operators.peek().equals("-")) || (expression[i].equals("+") && operators.peek().equals("-")) || (expression[i].equals("-") && operators.peek().equals("+"))
                            || (expression[i].equals("*") && operators.peek().equals("*")) || (expression[i].equals("/") && operators.peek().equals("/")) || (expression[i].equals("*") && operators.peek().equals("/")) || (expression[i].equals("/") && operators.peek().equals("*"))) {
                        System.out.printf("%s ", operators.pop());
                    } else if (expression[i].equals(")")) {
                        System.out.printf("%s ", operators.pop());
                        operators.pop();
                    }
                }
                if (!expression[i].equals(")")) {
                    operators.push(expression[i]);
                }
            }
        }
        while (operators.size() > 0) {
            System.out.print(operators.pop() + " ");
        }
    }
}
