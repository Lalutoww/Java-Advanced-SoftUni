package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Child> childrenList;
    private List<Parent> parentsList;
    private List<Pokemon> pokemonsList;

    public Person(String name) {
        this.name = name;
        this.childrenList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.pokemonsList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public List<Parent> getParentsList() {
        return parentsList;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private String getPrintableCompany() {
        if (company == null) {
            return "";
        }
        return company + System.lineSeparator();
    }

    private String getPrintableCar() {
        if (car == null) {
            return "";
        }
        return car + System.lineSeparator();
    }

    private String getPrintableChildrenList() {
        if (childrenList == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            childrenList.forEach(p -> sb.append(p).append("\n"));
            return sb.toString();
        }
    }

    private String getPrintableParentsList() {
        if (parentsList == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            parentsList.forEach(p -> sb.append(p).append("\n"));
            return sb.toString();
        }
    }

    private String getPrintablePokemon() {
        if (pokemonsList == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            pokemonsList.forEach(p -> sb.append(p).append("\n"));
            return sb.toString();
        }
    }

    @Override
    public String toString() {

        return name + System.lineSeparator() +
                "Company:\n" + getPrintableCompany() +
                "Car:\n" + getPrintableCar() +
                "Pokemon:\n" + getPrintablePokemon() +
                "Parents:\n" + getPrintableParentsList() +
                "Children:\n" + getPrintableChildrenList();

    }
}
