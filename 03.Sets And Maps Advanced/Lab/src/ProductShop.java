import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<String, Map<String, Double>> shops = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] shopData = input.split(",\\s+");
            String shop = shopData[0];
            String product = shopData[1];
            double price = Double.parseDouble(shopData[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);

            input = sc.nextLine();
        }

        shops.forEach((k, v) -> {
            System.out.println(k + "-> ");
            v.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            });
        });
    }
}
