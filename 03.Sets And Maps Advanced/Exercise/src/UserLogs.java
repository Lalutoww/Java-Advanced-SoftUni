import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<String, Map<String, Integer>> usersData = new TreeMap<>();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            //?message is not needed for this task
            String ip = data[0].split("=")[1];
            String user = data[2].split("=")[1];

            usersData.putIfAbsent(user, new LinkedHashMap<>());

            if (!usersData.get(user).containsKey(ip)) {
                usersData.get(user).put(ip, 1);
            } else {
                usersData.get(user).put(ip, usersData.get(user).get(ip) + 1);
            }

            input = sc.nextLine();
        }

        usersData.forEach((k, v) -> {
            System.out.println(k + ": ");
            printIPs(v);
        });
    }

    private static void printIPs(Map<String, Integer> v) {
        //?Prints '.' if it is the last ip, and ',' if there are more than 1 IPs
        Iterator<Map.Entry<String, Integer>> iterator = v.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> currentIpData = iterator.next();
            String ip = currentIpData.getKey();
            Integer count = currentIpData.getValue();

            if (v.size() > 1) {
                System.out.print(ip + " => " + count + ", ");
                iterator.remove();
            } else {
                System.out.print(ip + " => " + count + ".");
            }
        }
        System.out.println();
    }
}
