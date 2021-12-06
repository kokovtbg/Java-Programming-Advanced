package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> browserForwarded = new ArrayDeque<>();
        String line = scan.nextLine();
        String current = "";


        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!browserHistory.isEmpty()) {
                    browserForwarded.push(current);
                    current = browserHistory.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scan.nextLine();
                    continue;
                }
            } else if (line.equals("forward")) {
                if (!browserForwarded.isEmpty()) {
                    browserHistory.push(current);
                    current = browserForwarded.pop();
                } else {
                    System.out.println("no next URLs");
                    line = scan.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    browserHistory.push(current);
                }
                current = line;
            }
            System.out.println(current);
            line = scan.nextLine();
        }
    }
}
