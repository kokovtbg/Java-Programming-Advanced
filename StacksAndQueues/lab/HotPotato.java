package StacksAndQueues.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int number = Integer.parseInt(scan.nextLine());

        List<String> children = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        int count = 0;
        while (children.size() > 1) {
            for (int i = 0; i < children.size(); i++) {
                count++;
                if (count == number) {
                    count = 0;
                    System.out.printf("Removed %s%n", children.get(i));
                    children.remove(i);
                    if (i != 0) {
                        i--;
                    } else {
                        i = -1;
                    }
                }
                if (i == children.size() - 1) {
                    i = -1;
                }
                if (children.size() == 1) {
                    break;
                }
            }
        }
        System.out.printf("Last is %s", children.get(0));
    }
}
