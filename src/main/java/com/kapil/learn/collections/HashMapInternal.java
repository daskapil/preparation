package com.kapil.learn.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternal {
    public static void main(String[] args) {
        String s1 = "FB";
        String s2= new String("Ea");

        System.out.println("s1 hashcode: " + s1.hashCode());
        System.out.println("s2 hashcode: " + s2.hashCode());

        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 101);
        map.put(s2, 102);

        System.out.println("map: " + map);
    }
}
