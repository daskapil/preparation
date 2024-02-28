package com.kapil.algorithms.part1.union_find;

/*
 * Quick-find
 * Initialize: N
 * Union: N - is too expensive (N array accesses)
 * find: N
 * Tree cn get tall
 * */
public class QuickFindUF extends AbstractUF {
    private int[] id;

    public QuickFindUF(int N) {
        super(N);
        this.id = new int[N];
        // Set id of each object to itself (N array accesses)
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Change all entries with id[p] to id[q]
    // (at most 2N + 2 accesses)
    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    // Check if p and q are in the same component
    // (2 array accesses)
    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

}
