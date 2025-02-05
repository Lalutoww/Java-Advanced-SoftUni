import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());


        Map<String, UserData> logs = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String ip = data[0];
            String name = data[1];
            int duration = Integer.parseInt(data[2]);

            if (!logs.containsKey(name)) {
                logs.put(name, new UserData(duration, new TreeSet<>() {{
                    add(ip);
                }}));
            } else {
                UserData currentUser = logs.get(name);
                currentUser.setDuration(currentUser.getDuration() + duration);
                currentUser.addIpAddress(ip);
            }
        }

        logs.forEach((k, v) -> {
            System.out.printf("%s: %d [%s]%n", k, v.getDuration(), String.join(", ", v.getIpAddresses()));
        });
    }

    public static class UserData {
        private int duration;
        private Set<String> ipAddresses;

        public UserData(int duration, Set<String> ipAddresses) {
            this.duration = duration;
            this.ipAddresses = ipAddresses;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public Set<String> getIpAddresses() {
            return ipAddresses;
        }

        public void setIpAddresses(Set<String> ipAddresses) {
            this.ipAddresses = ipAddresses;
        }

        public void addIpAddress(String ip) {
            ipAddresses.add(ip);
        }
    }
}
