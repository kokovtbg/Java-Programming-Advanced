package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrayRobots = scan.nextLine().split(";");
        int[] time = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();

        String[] robotNames = new String[arrayRobots.length];
        int[] processTimes = new int[arrayRobots.length];
        int[] processTimeCurrent = new int[arrayRobots.length];
        for (int i = 0; i < arrayRobots.length; i++) {
            robotNames[i] = arrayRobots[i].split("-")[0];
            processTimes[i] = Integer.parseInt(arrayRobots[i].split("-")[1]);
            processTimeCurrent[i] = Integer.parseInt(arrayRobots[i].split("-")[1]);
        }
        int hours = time[0];
        int minutes = time[1];
        int seconds = time[2];
        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scan.nextLine();
        while (!product.equals("End")) {
            products.offer(product);

            product = scan.nextLine();
        }

        while (products.size() > 0) {
            seconds++;
            if (seconds == 60) {
                minutes++;
                seconds -= 60;
            }
            if (minutes == 60) {
                hours++;
                minutes -= 60;
            }
            boolean noRobots = true;
            int index = 0;
            for (int i = 0; i < robotNames.length; i++) {
                if (processTimes[i] == processTimeCurrent[i] && processTimes[i] != 0) {
                    processTimeCurrent[i]--;
                    index = i;
                    noRobots = false;
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotNames[i], products.poll(), hours, minutes, seconds);
                    break;
                } else if (processTimes[i] != processTimeCurrent[i] && processTimes[i] != 0){
                    processTimeCurrent[i]--;
                    if (processTimeCurrent[i] == 0) {
                        processTimeCurrent[i] = processTimes[i];
                    }
                }
            }
            if (noRobots) {
                products.offer(products.poll());
            } else {
                for (int i = index + 1; i < robotNames.length; i++) {
                    if (processTimes[i] != processTimeCurrent[i] && processTimes[i] != 0) {
                        processTimeCurrent[i]--;
                        if (processTimeCurrent[i] == 0) {
                            processTimeCurrent[i] = processTimes[i];
                        }
                    }
                }
            }
        }
    }
}
