package algorithms.baekjoon.sort;

public class Insertion {


    public void insertionSort(int[] arr) {
        CommonLog log = new CommonLog();
        for (int i = 1; i < arr.length; i++) {
            int curVal = arr[i];
            int position = i;
            while(position > 0 && arr[position - 1] > curVal) {
                arr[position] = arr[position - 1];
                position = position - 1;
                arr[position] = curVal;
            }
            log.printArr(arr);
        }
    }

}

