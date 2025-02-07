package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private double averageSalary;
    private List<Employee> employeeList;


    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public double getAverageSalary() {
        double totalSalary = 0;
        for (int i = 0; i < getEmployeeList().size(); i++) {
            totalSalary += getEmployeeList().get(i).getSalary();
        }

        return totalSalary / getEmployeeList().size();
    }
}
