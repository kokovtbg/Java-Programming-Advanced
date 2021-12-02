package DefiningClasses.exercise.PokemonTrainer1;

import java.util.*;
import java.util.stream.Collectors;

public class MainPokemonTrainer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<TrainerPokemonTrainer> trainers = new ArrayList<>();
        List<PokemonPokemonTrainer> pokemons = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            String nameTrainer = data[0];
            String namePokemon = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);
            boolean playerExists = false;
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().equals(nameTrainer)) {
                    List<String> collection = trainers.get(i).getCollection();
                    collection.add(namePokemon);
                    playerExists = true;
                }
            }
            if (!playerExists) {
                List<String> collection = new ArrayList<>();
                collection.add(namePokemon);
                TrainerPokemonTrainer trainer = new TrainerPokemonTrainer(nameTrainer, collection);
                trainers.add(trainer);
            }
            PokemonPokemonTrainer pokemon = new PokemonPokemonTrainer(namePokemon, element, health);
            pokemons.add(pokemon);

            input = scan.nextLine();
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            List<String> pokemonsWithElement = new ArrayList<>();
            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i).getElement().equals(command)) {
                    pokemonsWithElement.add(pokemons.get(i).getName());
                }
            }
            for (int i = 0; i < trainers.size(); i++) {
                boolean haveBadge = false;
                for (int j = 0; j < pokemonsWithElement.size(); j++) {
                    if (trainers.get(i).getCollection().contains(pokemonsWithElement.get(j))) {
                        haveBadge = true;
                    }
                }
                if (haveBadge) {
                    trainers.get(i).setBadges(trainers.get(i).getBadges() + 1);
                }
                if (!haveBadge) {
                    List<String> collection = trainers.get(i).getCollection();
                    boolean haveToRemovePoke = false;
                    List<String> pokesToRemove = new ArrayList<>();
                    for (int j = 0; j < collection.size(); j++) {
                        for (int k = 0; k < pokemons.size(); k++) {
                            if (collection.get(j).equals(pokemons.get(k).getName())) {
                                pokemons.get(k).setHealth(pokemons.get(k).getHealth() - 10);
                                if (pokemons.get(k).getHealth() <= 0) {
                                    pokesToRemove.add(pokemons.get(k).getName());
                                    pokemons.remove(pokemons.get(k));
                                    haveToRemovePoke = true;
                                }
                            }
                        }
                    }
                    if (haveToRemovePoke) {
                        while (pokesToRemove.size() > 0) {
                            trainers.get(i).getCollection().remove(pokesToRemove.get(0));
                            pokesToRemove.remove(0);
                        }
                    }
                }
            }

            command = scan.nextLine();
        }
        trainers = trainers.stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges())).collect(Collectors.toList());
        for (int i = 0; i < trainers.size(); i++) {
            System.out.printf("%s %d %d%n", trainers.get(i).getName(), trainers.get(i).getBadges(), trainers.get(i).getCollection().size());
        }
    }
}
