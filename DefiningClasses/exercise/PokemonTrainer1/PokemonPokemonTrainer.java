package DefiningClasses.exercise.PokemonTrainer1;

public class PokemonPokemonTrainer {
    private String name;
    private String element;
    private int health;

    public PokemonPokemonTrainer(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
