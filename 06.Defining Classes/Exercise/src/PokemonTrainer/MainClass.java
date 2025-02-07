package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        addTrainers(input, trainers, sc);

        String command = sc.nextLine();
        while (!command.equals("End")) {
            for (Trainer currentTrainer : trainers.values()) {
                dealWithPokemon(currentTrainer, command);
            }
            command = sc.nextLine();
        }
        trainers.values().stream()
                .sorted((a, b) -> Integer.compare(b.getBadges(), a.getBadges()))
                .forEach(System.out::println);
    }

    private static void dealWithPokemon(Trainer currentTrainer, String command) {
        if (currentTrainer.checkIfHasValidPokemon(command)) {
            currentTrainer.addBadge();
        } else {
            List<Pokemon> trainerPokemonList = currentTrainer.getPokemonList();
            for (int i = 0; i < trainerPokemonList.size(); i++) {
                Pokemon currentPokemon = trainerPokemonList.get(i);
                currentPokemon.removeHealth();
                if (currentPokemon.getHealth() == 0) {
                    trainerPokemonList.remove(currentPokemon);
                    i--;
                }
            }
        }
    }

    private static void addTrainers(String input, Map<String, Trainer> trainers, Scanner sc) {
        while (!input.equals("Tournament")) {
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);
            Trainer trainer;
            if (trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainer.addPokemon(pokemon);
            trainers.putIfAbsent(trainerName, trainer);
            input = sc.nextLine();
        }
    }
}
