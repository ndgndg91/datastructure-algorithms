package datastructure.algorithms.algorithms.baekjoon.sort;

public class CommonLog {
    Runtime runtime;
    long mb;
    long start;
    long end;
    static int[] arr = {5, 2, 4, 3, 1};
    static int[] arr1 = {10,6,3,9,1,4,8,2,7,5};
    static int[] arr2 = {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70
            ,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32
            ,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

    public CommonLog() {
        this.runtime = Runtime.getRuntime();
        this.mb = 1024*1024;
    }

    public long getStartTime(){
        start = System.currentTimeMillis();
        return this.start;
    }

    public long getEndTime(){
        end = System.currentTimeMillis();
        return this.end;
    }

    public void printMemory(CommonLog log){
        System.out.println((log.runtime.totalMemory() - log.runtime.freeMemory()) / log.mb + "MB");
    }

    public void printTime(long start, long end){
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
    }

    public void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +  " ");
        }
        System.out.println();
    }
}
