package datastructure.algorithms.algorithms.coursea.dynamicconnectivity;

import java.util.Arrays;
import java.util.StringJoiner;

public class QuickUnionUF {
    private final int[] id;

    public QuickUnionUF(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    private int root(int q){
        while (id[q] != q) q = id[q];
        return q;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QuickUnionUF.class.getSimpleName() + "[", "]")
                .add("id=" + Arrays.toString(id))
                .toString();
    }
}