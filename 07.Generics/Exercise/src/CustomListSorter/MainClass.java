package CustomListSorter;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String input = sc.nextLine();

        while (!input.equals("END")) {

            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Add" -> list.add(data[1]);
                case "Remove" -> list.remove(Integer.parseInt(data[1]));
                case "Contains" -> System.out.println(list.contains(data[1]));
                case "Swap" -> list.swap(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                case "Greater" -> System.out.println(list.countGreaterThan(data[1]));
                case "Max" -> System.out.println(list.getMax());
                case "Min" -> System.out.println(list.getMin());
                case "Print" -> System.out.println(list);
            }
            input = sc.nextLine();
        }
    }
}
