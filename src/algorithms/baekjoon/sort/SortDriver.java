package algorithms.baekjoon.sort;

public class SortDriver {
    public static void main(String[] args) {
        CommonLog log = new CommonLog();
        Bubble bubble = new Bubble();
        Selection selection = new Selection();
        Insertion insertion = new Insertion();
        Merge merge = new Merge();
        Quick quick = new Quick();
//        long start = log.getStartTime();
//        bubble.bubbleSort(log.arr1);
//        bubble.bubbleSort(log.arr2);
//        long end = log.getEndTime();
//        log.printTime(start,end);
//        log.printMemory(log);


//        long start2 = log.getStartTime();
//        quick.quickSort(log.arr1, 0, log.arr1.length-1);
//        for (int i = 0; i < log.arr1.length; i++) {
//            System.out.print(log.arr1[i] + " ");
//        }
//        long end2 = log.getEndTime();
//        log.printTime(start2, end2);
//        log.printMemory(log);

//        log.printArr(log.arr);
        quick.quickSort(log.arr,0, log.arr.length-1);
//        log.printArr(log.arr);
    }
}
