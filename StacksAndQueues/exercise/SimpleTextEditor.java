package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> commands = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            if (command.charAt(0) == '1') {
                text.append(command.split(" ")[1]);
                commands.push("append " + command.split(" ")[1]);
            }
            if (command.charAt(0) == '2') {
                int count = Integer.parseInt(command.split(" ")[1]);
                String textErased = text.substring(text.length() - count, text.length());
                text.delete(text.length() - count, text.length());
                commands.push("erase " + textErased);
            }
            if (command.charAt(0) == '3') {
                int index = Integer.parseInt(command.split(" ")[1]);
                System.out.println(text.toString().charAt(index - 1));
            }
            if (command.equals("4")) {
                if (commands.peek().split(" ")[0].equals("append")) {
                    text.delete(text.length() - commands.peek().split(" ")[1].length(), text.length());
                    commands.pop();
                } else if (commands.peek().split(" ")[0].equals("erase")) {
                    text.append(commands.peek().split(" ")[1]);
                    commands.pop();
                }
            }
        }
    }
}
