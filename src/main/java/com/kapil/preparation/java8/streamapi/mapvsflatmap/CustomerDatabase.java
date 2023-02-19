package com.kapil.preparation.java8.streamapi.mapvsflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDatabase {
    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "Kapil", "kapil@email.com", Arrays.asList("1234567890", "0987654321")),
                new Customer(102, "Chaitali", "Chaitali@email.com", Arrays.asList("3124569876", "0987654321")),
                new Customer(103, "Ahana", "Ahana@email.com", Arrays.asList("3124569876", "0987654321")),
                new Customer(104, "Kalika", "kalika@email.com", Arrays.asList("3124569876", "0987654321")),
                new Customer(105, "Dilip", "Dilip@email.com", Arrays.asList("3124569876", "0987654321"))
        ).collect(Collectors.toList());
    }
}
