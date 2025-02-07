package CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private Department department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, Department department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
