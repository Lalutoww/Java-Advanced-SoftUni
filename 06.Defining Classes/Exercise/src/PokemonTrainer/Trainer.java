package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public boolean checkIfHasValidPokemon(String element) {
        return pokemonList.stream().anyMatch(p -> p.getElement().equals(element));
    }

    public int getBadges() {
        return badges;
    }

    public void addBadge() {
        badges++;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + pokemonList.size();
    }
}
