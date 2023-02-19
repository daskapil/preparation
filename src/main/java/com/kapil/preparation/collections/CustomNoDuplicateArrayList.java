package com.kapil.preparation.collections;

import java.util.ArrayList;

public class CustomNoDuplicateArrayList extends ArrayList {
    @Override
    public boolean add(Object o) {
        if(this.contains(o)){
            return true;
        } else {
            return super.add(o);
        }

    }

    public static void main(String[] args) {
        CustomNoDuplicateArrayList customNoDuplicateArrayList = new CustomNoDuplicateArrayList();
        customNoDuplicateArrayList.add(1);
        customNoDuplicateArrayList.add(1);
        customNoDuplicateArrayList.add(1);
        customNoDuplicateArrayList.add(2);

        System.out.println(customNoDuplicateArrayList);
    }
}
