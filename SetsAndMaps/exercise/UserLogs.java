package SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String ipAddress = data[0].substring(3);
            String user = data[2].substring(5);
            Map<String, Integer> ipAddresses;
            if (!userLogs.containsKey(user)) {
                ipAddresses = new LinkedHashMap<>();
                ipAddresses.put(ipAddress, 1);
            } else {
                ipAddresses = userLogs.get(user);
                if (!ipAddresses.containsKey(ipAddress)) {
                    ipAddresses.put(ipAddress, 1);
                } else {
                    ipAddresses.put(ipAddress, ipAddresses.get(ipAddress) + 1);
                }
            }
            userLogs.put(user, ipAddresses);

            input = scan.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : userLogs.entrySet()) {
            System.out.printf("%s: %n", entry.getKey());
            int count = 0;
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                count++;
                if (count < entry.getValue().size()) {
                    System.out.printf("%s => %d, ", entry2.getKey(), entry2.getValue());
                } else {
                    System.out.printf("%s => %d.%n", entry2.getKey(), entry2.getValue());
                }
            }
        }
    }
}
