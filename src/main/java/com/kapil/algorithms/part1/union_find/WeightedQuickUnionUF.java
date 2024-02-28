package com.kapil.algorithms.part1.union_find;

/*
 * Weighted Quick-Union
 * Link the root of small tree to root of larger tree
 * Initialize: N
 * Union: log N
 * find: log N
 * find path compression: log* N - called Iterated Logarithm - much faster
 * Depth of any Node x is at most logN (base - 2)
 *
 * */
public class WeightedQuickUnionUF extends AbstractUF {
    private int[] id;

    // Count number of object in the tree root at i
    private final int[] size;

    public WeightedQuickUnionUF(int N) {
        super(N);
        this.id = new int[N];
        this.size = new int[N];
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
        if(i == j) return;

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] +=size[i];
        } else {
            id[j] = i;
            size[i] +=size[j];
        }

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
            id[i] = id[id[i]]; // Path compression Keeps tree completely flat. improves performance
            i = id[i];
        }
        return i;
    }

}
