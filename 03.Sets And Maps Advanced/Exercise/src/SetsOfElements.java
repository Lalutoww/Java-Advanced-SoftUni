import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Set<Integer> setOne = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            setOne.add(Integer.parseInt(sc.nextLine()));
        }

        Set<Integer> setTwo = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            setTwo.add(Integer.parseInt(sc.nextLine()));
        }

        //?retainAll keeps only the elements in the set that are common to the other set
        setOne.retainAll(setTwo);
        setOne.forEach(s -> System.out.print(s + " "));
    }
}
