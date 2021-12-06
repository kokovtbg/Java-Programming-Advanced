package SetsAndMaps.exercise;

import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String username = scan.nextLine();
            usernames.add(username);
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
