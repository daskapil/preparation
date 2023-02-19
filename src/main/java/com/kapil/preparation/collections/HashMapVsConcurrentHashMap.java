package com.kapil.preparation.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapVsConcurrentHashMap extends Thread {
//    static Map<Integer, String> map = new HashMap<>();
    static Map<Integer, String> map = new ConcurrentHashMap<>()    ;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            // Child thread trying to add
            // new element in the object
            map.put(103, "D");
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        map.put(100, "A");
        map.put(101, "B");
        map.put(102, "C");
        HashMapVsConcurrentHashMap hashMapVsConcurrentHashMap = new HashMapVsConcurrentHashMap();
        hashMapVsConcurrentHashMap.start();

        for (Object o : map.entrySet()) {
            Object s = o;
            System.out.println(s);
            Thread.sleep(1000);
        }

        System.out.println(map);
        //Segment locking or bucket locking
    }
}
