package CompanyRoster;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Department> departments = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] employeeData = sc.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String departmentName = employeeData[3];

            Department department;
            if (!departments.containsKey(departmentName)) {
                department = new Department(departmentName);
            } else {
                department = departments.get(departmentName);
            }

            Employee employee = new Employee(name, salary, position, department);

            if (employeeData.length == 5) {
                if (employeeData[4].contains("@")) {
                    String email = employeeData[4];
                    employee.setEmail(email);
                } else {
                    int age = Integer.parseInt(employeeData[4]);
                    employee.setAge(age);
                }
            } else if (employeeData.length == 6) {
                String email = employeeData[4];
                int age = Integer.parseInt(employeeData[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }

            department.addEmployee(employee);
            departments.putIfAbsent(departmentName, department);
        }

        Department highestPaidDepartment = departments.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue().getAverageSalary(), a.getValue().getAverageSalary()))
                .toList().getFirst().getValue();

        System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());
        highestPaidDepartment.getEmployeeList().stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).forEach(System.out::println);
    }
}
