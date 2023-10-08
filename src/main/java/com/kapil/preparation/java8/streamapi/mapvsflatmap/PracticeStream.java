package com.kapil.preparation.java8.streamapi.mapvsflatmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeStream {

    private static Employee[] employees = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };


    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName() + " started");
            }
        });

        t.start();

        Thread t2 = new Thread(() -> System.out.println("Thread: " + Thread.currentThread().getName() + " started"));
        t2.start();

        //---------------------------------------------

        List<Customer> customers = CustomerDatabase.getAll();
        List<String> emails = customers.stream()
                .map(Customer::getEmail)
                .collect(Collectors.toList());
        System.out.println(emails);

        List<List<String>> phoneNumbers = customers.stream()
                .map(Customer::getPhoneNumbers)
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);

        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
        // ----------------------------------------------------

        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctList = intList.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct: \n" + distinctList);
        // ----------------------------------------------------
        List<String> listOfString = Arrays.asList("john", "smith", "jack");
        Map<String, String> mapStr = listOfString.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toMap(s -> s, s -> s));
        System.out.println(mapStr);
        // ----------------------------------------------------

        List<Employee> employeeList = Arrays.asList(employees);
        Stream.Builder<Employee> employeeStreamBuilder = Stream.builder();
        employeeStreamBuilder.accept(employees[0]);
        employeeStreamBuilder.accept(employees[1]);
        employeeStreamBuilder.accept(employees[2]);
        Stream<Employee> employeeStream = employeeStreamBuilder.build();

        List<Employee> list = Stream.of(employees)
                .map(employee -> {
                    double newSalary = employee.getSalary() * 1.01;
                    employee.setSalary(newSalary);
                    return employee;
                }).collect(Collectors.toList());

        List<Employee> newEpmList = list.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("*** New Employee List: \n" + newEpmList);

        Double avgSalary = newEpmList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("avgSalary: " + avgSalary);

        Employee employee = list.stream()
                .filter(e -> e.getSalary() > 100000.0)
                .findFirst()
                .orElse(null);
        System.out.println(employee);

        list.toArray(Employee[]::new);
    }
}
