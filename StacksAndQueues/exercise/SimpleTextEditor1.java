package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> wordStates = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            String command = scan.nextLine();
            String commandNumber = command.split("\\s+")[0];
            switch (commandNumber) {
                case "1":
                    String textToAdd = command.split("\\s+")[1];
                    currentText.append(textToAdd);
                    wordStates.push(currentText.toString());
                    break;
                case "2":
                    int countElements = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = currentText.length() - countElements;
                    currentText.delete(startIndex, startIndex + countElements);
                    wordStates.push(currentText.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case "4":
                    if (wordStates.size() > 1) {
                        wordStates.pop();
                        currentText = new StringBuilder();
                        currentText.append(wordStates.peek());
                    } else {
                        currentText = new StringBuilder();
                    }
                    break;

            }
        }
    }
}
