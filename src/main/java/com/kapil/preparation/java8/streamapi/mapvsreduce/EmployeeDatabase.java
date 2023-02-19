package com.kapil.preparation.java8.streamapi.mapvsreduce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {
    public static List<Employee> getAll() {
        Set<Address> addressSam = Stream.of(
                new Address(00000),
                new Address(00001)
        ).collect(Collectors.toSet());

        Set<Address> addressJohn = new HashSet<>(
                Arrays.asList(
                        new Address(00001),
                        new Address(00002)
                ));

        Set<Address> addressKelly = new HashSet<>(
                Arrays.asList(
                        new Address(00002),
                        new Address(00003)
                ));

        return Stream.of(
                new Employee(101, "Sam", "A", 150000, addressSam),
                new Employee(102, "John", "A", 160000, addressJohn),
                new Employee(103, "Kelly", "B", 100000, addressKelly)
        ).collect(Collectors.toList());
    }
}
