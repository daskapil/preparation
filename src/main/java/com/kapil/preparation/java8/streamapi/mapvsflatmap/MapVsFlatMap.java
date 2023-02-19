package com.kapil.preparation.java8.streamapi.mapvsflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers = CustomerDatabase.getAll();
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
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

        /*
         * List<String> listOfString = Arrays.asList("john", "smith", "jack");
         * Map<String, String> mapStr = <add logic here>;
         * Output = { JOHN=JOHN , SMITH=SMITH , JACK=JACK}
         * */
        List<String> listOfString = Arrays.asList("john", "smith", "jack");
//        List<String> mapStr = listOfString.stream().map(String::toUpperCase).collect(Collectors.toList());
        Map<String, String> mapStr = listOfString.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toMap(s -> s, s -> s));
//        for (String s : listOfString) {
//            mapStr.put(s.toUpperCase(), s.toUpperCase());
//        }

        System.out.println(mapStr);

    }
}
