package algorithms.programers.Sort.KthNumber;

import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++){
            int[] temp = new int[commands[i][1] - commands[i][0]+1];
            int idx = 0;
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                temp[idx++] = array[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
    @SuppressWarnings("Duplicates")
    static void mergeSort(int[] arr, int length) {
        if (length < 2)
            return;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, left.length);
        mergeSort(right, right.length);

        merge(arr , left, right, left.length, right.length);
    }
    static void merge(int[] arr, int[] left, int[] right, int leftLength, int rightLength){
        int i = 0, l = 0, r = 0;
        while (l < leftLength && r < rightLength) {
            if (left[l] < right[r])
                arr[i++] = left[l++];
            else
                arr[i++] = right[r++];
        }
        while (l < leftLength){
            arr[i++] = left[l++];
        }
        while (r < rightLength){
            arr[i++] = right[r++];
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5 ,3},
                {4, 4, 1},
                {1, 7, 3}
        };
        int[] result = solution(array, commands);
        for (int i : result) {
            System.out.println(i);
        }
    }
}


//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]