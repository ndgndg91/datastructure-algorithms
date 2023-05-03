package datastructure.algorithms.algorithms.baekjoon.sort;

public class Merge {

    public void mergeSort(int[] a, int n, CommonLog log) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        log.printArr(l);
        log.printArr(r);
        mergeSort(l, mid, log);
        mergeSort(r, n - mid, log);

        merge(a, l, r, mid, n - mid, log);
    }

    public void merge(
            int[] a, int[] l, int[] r, int left, int right, CommonLog log) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        log.printArr(a);
    }
}
