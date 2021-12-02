package DefiningClasses.exercise.PokemonTrainer1;

import java.util.List;

public class TrainerPokemonTrainer {
    private String name;
    private int badges;
    private List<String> collection;

    public TrainerPokemonTrainer(String name, List<String> collection) {
        this.name = name;
        this.badges = 0;
        this.collection = collection;
    }

    public List<String> getCollection() {
        return collection;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }
}
