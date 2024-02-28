package com.kapil.algorithms.part1.union_find;

/*
 * Quick-Union
 * Initialize: N
 * Union: N - is too expensive
 * find: 1
 * Takes N^2 (quadratic) array accesses to process sequence of N unions commands on N objects
 * */
public class QuickUnionUF extends AbstractUF {
    private int[] id;

    public QuickUnionUF(int N) {
        super(N);
        this.id = new int[N];
        // Set id of each object to itself (N array accesses)
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Change root of p to root of q
    // (depth of p and q array accesses)
    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    // Check if p and q are in the same root
    // (depth of p and q array accesses)
    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    // chase parent pointer until reach the root
    // (depth of i array accesses)
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

}
