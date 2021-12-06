package SetsAndMaps.lab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        LinkedHashSet<Integer> firstPlayer = (LinkedHashSet<Integer>) Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());
//        LinkedHashSet<Integer> secondPlayer = (LinkedHashSet<Integer>) Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());
        List<Integer> firstPlayer = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < 50; i++) {
            int firstNumber = Collections.max(firstPlayer);
            firstPlayer.remove((Integer) firstNumber);
            int secondNumber = Collections.max(secondPlayer);
            secondPlayer.remove((Integer) secondNumber);
            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
        }
        if (firstPlayer.isEmpty()) {
            System.out.printf("Second player win!%n");
        } else if (secondPlayer.isEmpty()) {
            System.out.printf("First player win!%n");
        } else {
            System.out.printf("Draw%n");
        }
    }
}
