import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> junkMaterials = new LinkedHashMap<>();
        Map<String, Integer> keyMaterials = new LinkedHashMap<>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};

        boolean isItemObtained = false;
        while (!isItemObtained) {
            String[] data = sc.nextLine().split("\\s+");
            for (int i = 0; i < data.length - 1; i += 2) {
                int quantity = Integer.parseInt(data[i]);
                String material = data[i + 1].toLowerCase();

                if (material.equals("fragments") || material.equals("shards") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, quantity);
                    } else {
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                    }
                }

                isItemObtained = isIsItemObtained(keyMaterials);

                if (isItemObtained) {
                    break;
                }
            }
        }

        printKeyMaterials(keyMaterials);
        printJunkMaterials(junkMaterials);
    }

    private static void printJunkMaterials(Map<String, Integer> junk) {
        junk.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void printKeyMaterials(Map<String, Integer> keyMaterials) {
        keyMaterials.entrySet().stream().sorted((a, b) -> {
            if (Integer.parseInt(String.valueOf(a.getValue())) != Integer.parseInt(String.valueOf(b.getValue()))) {
                return Integer.compare(b.getValue(), a.getValue());
            }
            return a.getKey().compareTo(b.getKey());
        }).forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static boolean isIsItemObtained(Map<String, Integer> keyMaterials) {
        boolean isItemObtained = false;

        if (keyMaterials.get("shards") >= 250) {
            keyMaterials.put("shards", keyMaterials.get("shards") - 250);
            System.out.println("Shadowmourne obtained!");
            isItemObtained = true;
        } else if (keyMaterials.get("fragments") >= 250) {
            keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
            System.out.println("Valanyr obtained!");
            isItemObtained = true;
        } else if (keyMaterials.get("motes") >= 250) {
            keyMaterials.put("motes", keyMaterials.get("motes") - 250);
            System.out.println("Dragonwrath obtained!");
            isItemObtained = true;
        }
        return isItemObtained;
    }
}
