import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotData = scanner.nextLine().split(";");
        Map<String, Integer> robots = new LinkedHashMap<>();
        Map<String, Integer> busyTime = new HashMap<>();

        for (String data : robotData) {
            String[] parts = data.split("-");
            robots.put(parts[0], Integer.parseInt(parts[1]));
            busyTime.put(parts[0], 0);
        }

        int currentTime = getTimeInSeconds(scanner.nextLine());

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String product;
        while (!(product = scanner.nextLine()).equals("End")) {
            productsQueue.offer(product);
        }

        while (!productsQueue.isEmpty()) {
            currentTime++;
            String currentProduct = productsQueue.poll();
            boolean assigned = false;

            for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                if (busyTime.get(robot.getKey()) == 0) {
                    busyTime.put(robot.getKey(), robot.getValue());
                    System.out.printf("%s - %s [%s]\n", robot.getKey(), currentProduct, formatTime(currentTime));
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                productsQueue.offer(currentProduct);
            }

            busyTime.replaceAll((key, time) -> Math.max(0, time - 1));
        }
    }

    private static int getTimeInSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 +
                Integer.parseInt(parts[1]) * 60 +
                Integer.parseInt(parts[2]);
    }

    private static String formatTime(int seconds) {
        return String.format("%02d:%02d:%02d", (seconds / 3600) % 24, (seconds % 3600) / 60, seconds % 60);
    }
}