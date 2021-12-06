package SetsAndMaps.lab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 50;

        while (rounds-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            Iterator<Integer> firstIterator = firstDeck.iterator();
            Iterator<Integer> secondIterator = secondDeck.iterator();
            int firstCard = firstIterator.next();
            firstIterator.remove();
            int secondCard = secondIterator.next();
            secondIterator.remove();
            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.printf("First player win!%n");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.printf("Second player win!%n");
        } else {
            System.out.printf("Draw!%n");
        }
    }
}
