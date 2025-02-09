package ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int compareTo(Person p) {
        if (name.compareTo(p.name) == 0) {
            if (age == p.age) {
                return city.compareTo(p.city);
            }
            return Integer.compare(age, p.age);
        }
        return name.compareTo(p.name);
    }
}
