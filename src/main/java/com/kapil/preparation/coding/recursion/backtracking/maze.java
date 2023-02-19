package com.kapil.preparation.coding.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path(3, 3);
        System.out.println(pathReturn(3, 3));
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;
    }

    static void path(int r, int c) {
        path("", r, c);
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p + "D", r - 1, c);
        }

        if (c > 1) {
            path(p + "R", r, c - 1);
        }
    }

    static List<String> pathReturn(int r, int c) {
        return pathReturn("", r, c);
    }

    static List<String> pathReturn(String p, int r, int c) {
        List<String> list = new ArrayList<>();

        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }

        if (r > 1) {
            list.addAll(pathReturn(p + "D", r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathReturn(p + "R", r, c - 1));
        }

        return list;
    }
}
