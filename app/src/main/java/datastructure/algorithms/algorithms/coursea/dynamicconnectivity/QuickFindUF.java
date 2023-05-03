package datastructure.algorithms.algorithms.coursea.dynamicconnectivity;

import java.util.Arrays;
import java.util.StringJoiner;

public class QuickFindUF {

    private int[] d;

    public QuickFindUF(int n) {
        d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return d[p] == d[q];
    }

    // linear
    // if n times union operation to n length BigO(n*n), so slow
    public void union(int p, int q) {
        int pid = d[p];
        int qid = d[q];
        for (int i = 0; i < d.length; i++) {
            if (d[i] == pid) d[i] = qid;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QuickFindUF.class.getSimpleName() + "[", "]")
                .add("d=" + Arrays.toString(d))
                .toString();
    }
}
