package datastructure.algorithms.algorithms.hackerrank.TwoDArray;

import java.util.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int a = 0; a < 4; a++) {
            for (int i = 0; i < 4; i++) {
                int tempValue = 0;
                int rowFlag = -1;
                for (int j = i; j < i+3; j++) {
                    rowFlag++;
                    int colFlag = -1;
                    for (int k = a; k < a+3; k++) {
                        colFlag++;
                        if(rowFlag == 1) {
                            if (colFlag == 1){
                                tempValue += arr[j][k];
                            }
                        } else {
                            tempValue += arr[j][k];
                        }
                        // System.out.print(arr[j][k] +" ");
                    }
                    // System.out.println();
                }
                // System.out.println(tempValue);
                maxValue = Math.max(maxValue, tempValue);
            }
            // System.out.println();
        }
        System.out.println(maxValue);
        scanner.close();
    }
}
