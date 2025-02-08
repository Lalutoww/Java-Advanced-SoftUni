package CountDoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Double> doubles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double element = Double.parseDouble(sc.nextLine());
            doubles.add(element);
        }

        double elementToCheck = Double.parseDouble(sc.nextLine());

        int count = getCount(doubles, elementToCheck);
        System.out.println(count);
    }

    private static <T extends Comparable<T>> int getCount(List<T> list, T compareParameter) {
        int count = 0;

        for (T element : list) {
            if (element.compareTo(compareParameter) > 0) {
                count++;
            }
        }
        return count;
    }
}
