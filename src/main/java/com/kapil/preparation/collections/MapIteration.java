package com.kapil.preparation.collections;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Robert C. Martin", "Clean Code");
        map.put("Joshua Bloch", "Effective Java");

        for (String key: map.keySet()){
            System.out.println("Key: " + key + " value: "+ map.get(key));
        }

        for (Map.Entry<String, String> book: map.entrySet()){
            System.out.println("Key: " + book.getKey() + " Value: " + book.getValue());
        }
    }
}
