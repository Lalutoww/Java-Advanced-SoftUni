package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] personData = input.split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String city = personData[2];

            people.add(new Person(name, age, city));

            input = sc.nextLine();
        }

        int n = Integer.parseInt(sc.nextLine()) - 1;
        Person personToCompare = people.remove(n);
        int matches = 0;
        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                matches++;
            }
        }

        if (matches == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", matches + 1, (people.size() + 1) - (matches + 1), people.size() + 1);
        }

    }
}
