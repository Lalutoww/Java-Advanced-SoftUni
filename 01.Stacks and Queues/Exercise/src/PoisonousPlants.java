import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(sc.nextLine());
        List<List<Integer>> plants = new ArrayList<>();
        int[] pesticides = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        addPlantsAndPesticides(numberOfPlants, plants, pesticides);

        System.out.println(getDays(plants));
    }

    private static void addPlantsAndPesticides(int numberOfPlants, List<List<Integer>> plants, int[] pesticides) {
        for (int i = 0; i < numberOfPlants; i++) {
            for (int j = i; j <= i; j++) {
                plants.add(List.of(pesticides[i], j + 1));
            }
        }
    }

    private static int getDays(List<List<Integer>> plants) {
        int days = 0;
        List<List<Integer>> plantsToRemove;
        do {
            plantsToRemove = new ArrayList<>();
            for (int i = 0; i < plants.size() - 1; i++) {
                List<Integer> firstPlant = plants.get(i);
                List<Integer> secondPlant = plants.get(i + 1);

                if (secondPlant.getFirst() > firstPlant.getFirst()) {
                    plantsToRemove.add(secondPlant);
                }
            }

            for (List<Integer> plantToRemove : plantsToRemove) {
                plants.remove(plantToRemove);
            }
            days++;
        } while (!plantsToRemove.isEmpty());
        return days - 1;
    }
}
