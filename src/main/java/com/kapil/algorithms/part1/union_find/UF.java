package com.kapil.algorithms.part1.union_find;

public class UF {
    int N;

    // Initialize union-find data structure with N objects (0 to N-1)
    UF(int N) {
        this.N = N;
    }

    // Add connection between p and q
    void union(int p, int q) {

    }

    // Are p and q in same component?
    boolean connected(int p, int q) {
        return false;
    }

    // Component identifier for p (0 to N-1)
    int find(int p) {
        return 0;
    }

    // Numbers of components
    int count() {
        return N;
    }
}
