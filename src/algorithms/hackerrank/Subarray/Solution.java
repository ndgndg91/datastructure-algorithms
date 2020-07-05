package algorithms.hackerrank.Subarray;

import java.util.*;

//5
//1 -2 4 -5 1
//1 2 3 4 5
public class Solution {
    private static int subArrCnt = 0;
    private static ArrayList<Integer> subArr = new ArrayList<>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int elementsCount = scn.nextInt();
        int[] arr = new int[elementsCount];
        boolean[] visit = new boolean[elementsCount];

        for (int i = 0; i < elementsCount; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        for ( int a = 0; a < arr.length; a++ ) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = a; j <= i; j++) {
                    subArr.add(arr[j]);
                }
                int sum = 0;
                if (subArr.size() > 0) {
                    for (int t : subArr) {
                        sum += t;
                    }
                    if ( sum < 0 )
                        subArrCnt++;
                }
//                for (int t : subArr) {
//                    System.out.print(t + " ");
//                }
//                System.out.println();
                subArr.clear();
            }
        }
    }



}


