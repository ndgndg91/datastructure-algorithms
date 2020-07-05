package algorithms.baekjoon.sort;

public class Selection {

    public void selectionSort(int[] arr){
        CommonLog log = new CommonLog();
        for (int i = 0; i < arr.length -1; i++) {
            int min_Val = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_Val]) {
                    min_Val = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_Val];
            arr[min_Val] = temp;
            log.printArr(arr);
        }

    }
}
