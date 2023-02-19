package com.kapil.preparation.java8.streamapi.mapvsreduce;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDatabase.getAll();

        getUniqueZipCode(employees);
        getAvgSalaryOfGradeAEmployee(employees);

    }

    /*Map()*/
    private static void getAvgSalaryOfGradeAEmployee(List<Employee> employees) {
        double avgSalaryOfGradeAEmployee = employees.stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
        System.out.println("Avg Salary Of Grade-A Employee: " + avgSalaryOfGradeAEmployee);
    }

    /*Map() & FlatMap()*/
    private static void getUniqueZipCode(List<Employee> employees) {
        Set<Integer> uniqueZips = employees.stream()
                .flatMap(employee -> employee.getAddresses().stream())
                .map(Address::getZip)
                .collect(Collectors.toSet());

        System.out.println("Unique Zip codes are: " + uniqueZips);
    }
}
