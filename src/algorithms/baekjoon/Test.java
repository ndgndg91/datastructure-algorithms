package algorithms.baekjoon;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        int[] healths = {200, 120, 150};
        int[][] items = {{30, 100}, {500, 30}, {100, 400}};
        solution(healths, items);
        ArrayList<Integer> arr = getPrime(33);
        for (int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
    }

    public static int[] solution(int[] healths, int[][] items) {
        boolean[] isUsed = new boolean[items.length];
        boolean[] isDiff = new boolean[healths.length];
        for (int i = 0; i < healths.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (healths[i] - items[j][1] >= 100 && !isUsed[j] && !isDiff[i]) {
                    isUsed[j] = true;
                    isDiff[i] = true;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < isUsed.length; i++) {
            if (isUsed[i]) {
                arr.add(i+1);
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i <arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public static ArrayList<Integer> getPrime(int num) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 2; // i : 나눌 대상
        boolean isPrime = true;

        while (i <= num) {
            isPrime = true;

            for (int n = 2; n < i; n++) {
                if (i % n == 0) {
                    isPrime = false;
                }
                continue;
            }

            if (isPrime == true)
                arr.add(i);
            i++;
        }
        return arr;
    }

    @SuppressWarnings("Duplicates")
    public static void quickSort(int[] arr, int begin, int end ) {
        if (begin < end) {
            int partitionIdx = partition(arr, begin, end);

            quickSort(arr, begin, partitionIdx - 1);
            quickSort(arr, partitionIdx + 1, end);
        }
    }

    @SuppressWarnings("Duplicates")
    public static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[end] = temp;

        return i+1;
    }

    @SuppressWarnings("Duplicates")
    public static void mergeSort(int[] arr, int n){
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int j = mid; j < n; j++) {
            r[j-mid] = arr[j];
        }
        mergeSort(l, mid);
        mergeSort(r, n-mid);

        merge(arr, l, r, mid, n-mid);
    }

    @SuppressWarnings("Duplicates")
    public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }

    }

}
