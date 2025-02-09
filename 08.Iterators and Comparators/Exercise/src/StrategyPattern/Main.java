package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Person> personNameSet = new TreeSet<>(new PersonNameComparator());
        Set<Person> personAgeSet = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String personData = sc.nextLine();
            String name = personData.split("\\s+")[0];
            int age = Integer.parseInt(personData.split("\\s+")[1]);

            Person person = new Person(name, age);
            personNameSet.add(person);
            personAgeSet.add(person);
        }

        personNameSet.forEach(System.out::println);
        personAgeSet.forEach(System.out::println);
    }

}
