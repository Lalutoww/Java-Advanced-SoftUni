package GenericBox;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String element = sc.nextLine();
            Box<String> box = new Box<>(element);
            System.out.println(box);
        }
    }
}
