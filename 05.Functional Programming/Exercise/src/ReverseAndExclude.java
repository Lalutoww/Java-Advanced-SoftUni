import java.util.*;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = new ArrayList<>(Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).toList());

        int n = sc.nextInt();
        Collections.reverse(input);
        input.stream().filter(x -> x % n != 0).forEach(x -> System.out.printf(x + " "));
    }
}
