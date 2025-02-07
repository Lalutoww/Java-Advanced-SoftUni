package Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, Person> people = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String field = data[1];

            Person person;
            if (people.containsKey(name)) {
                person = people.get(name);
            } else {
                person = new Person(name);
            }

            switch (field) {
                case "company" -> {
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                }
                case "pokemon" -> {
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.getPokemonsList().add(pokemon);
                }
                case "parents" -> {
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person.getParentsList().add(parent);
                }
                case "children" -> {
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    person.getChildrenList().add(child);
                }
                case "car" -> {
                    String currentCar = data[2];
                    String carSpeed = data[3];
                    Car car = new Car(currentCar, carSpeed);
                    person.setCar(car);
                }
            }
            people.put(name, person);
            input = sc.nextLine();
        }
        input = sc.nextLine();
        System.out.println(people.get(input).toString());
    }
}