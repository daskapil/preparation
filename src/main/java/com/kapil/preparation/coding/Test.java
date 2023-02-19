package com.kapil.preparation.coding;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        boolean is = Boolean.parseBoolean("true");
        System.out.println(is);

        System.out.println(list.size());
        System.out.println(list.get(1) instanceof Boolean);
        System.out.println(list.get(1 ));
    }
}
