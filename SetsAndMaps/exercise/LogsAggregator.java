package SetsAndMaps.exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> usersDurationIPs = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] data = input.split("\\s+");
            String ipAddress = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            List<String> durationIPs;
            if (!usersDurationIPs.containsKey(user)) {
                durationIPs = new ArrayList<>();
                durationIPs.add(duration + "");
            } else {
                durationIPs = usersDurationIPs.get(user);
                int sumDuration = duration + Integer.parseInt(durationIPs.get(0));
                durationIPs.set(0, sumDuration + "");
            }
            if (!durationIPs.contains(ipAddress)) {
                durationIPs.add(ipAddress);
            }
            usersDurationIPs.put(user, durationIPs);

        }
        for (Map.Entry<String, List<String>> entry : usersDurationIPs.entrySet()) {
            System.out.printf("%s: %s [", entry.getKey(), entry.getValue().get(0));
            List<String> sortedIPs = new ArrayList<>();
            for (int i = 1; i < entry.getValue().size(); i++) {
                sortedIPs.add(entry.getValue().get(i));
            }
            Collections.sort(sortedIPs);
            System.out.print(String.join(", ", sortedIPs));
            System.out.println("]");

        }
    }
}
