package com.kapil.preparation;

import com.kapil.Direction;

import java.util.ArrayList;
import java.util.List;

class HelloWorld {
    private String berry;
    public static void main(String[] args) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.moo();
//        helloWorld.nameBerry("rash");
//        int jar = pickle;
    }

    private void nameBerry(String berry) {
        this.berry = "straw";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).trim();
        }
        System.out.println(berry + "berry");
    }

    private void moo() throws Exception {
        foo("Hello World");
    }

    private void foo(String helloWorld) throws Exception {
        try {
            throw new Exception("try");
        } finally {
            throw new Exception("finally");
        }
    }

    static void hello(){

    }




}