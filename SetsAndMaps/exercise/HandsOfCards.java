package SetsAndMaps.exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> playersDecks = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("JOKER")) {
            String[] data = input.split(":\\s+|,\\s+");
            String namePlayer = data[0];
            List<String> deck;
            if (!playersDecks.containsKey(namePlayer)) {
                deck = new ArrayList<>();
            } else {
                deck = playersDecks.get(namePlayer);
            }
            for (int i = 1; i < data.length; i++) {
                if (!deck.contains(data[i])) {
                    deck.add(data[i]);
                }
            }
            playersDecks.put(namePlayer, deck);

            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : playersDecks.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            int sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                String card = entry.getValue().get(i);
                int power;
                if (card.charAt(0) == 'J') {
                    power = 11;
                } else if (card.charAt(0) == 'Q') {
                    power = 12;
                } else if (card.charAt(0) == 'K') {
                    power = 13;
                } else if (card.charAt(0) == 'A') {
                    power = 14;
                } else {
                    power = Integer.parseInt(card.substring(0, card.length() - 1));
                }
                char type = card.charAt(card.length() - 1);
                if (type == 'S') {
                    power *= 4;
                } else if (type == 'H') {
                    power *= 3;
                } else if (type == 'D') {
                    power *= 2;
                }
                sum += power;
            }
            System.out.println(sum);
        }
    }
}
