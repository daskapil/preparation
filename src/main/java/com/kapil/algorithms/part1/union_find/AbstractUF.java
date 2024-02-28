package com.kapil.algorithms.part1.union_find;

public abstract class AbstractUF {
    public int N;

    // Initialize union-find data structure with N objects (0 to N-1)
    protected AbstractUF(int N) {
        this.N = N;
    }

    // Add connection between p and q.
    public abstract void union(int p, int q);

    // Are p and q in same component?
    public abstract boolean connected(int p, int q);

    // Component identifier for p (0 to N-1)
    public abstract int find(int p);

    // Numbers of components
    public int count() {
        return N;
    }
}
