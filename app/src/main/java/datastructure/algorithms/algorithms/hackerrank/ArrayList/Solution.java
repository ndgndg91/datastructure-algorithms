package datastructure.algorithms.algorithms.hackerrank.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        ArrayList<int[]> arrayList = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        scn.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int n = scn.nextInt();
        for (int i = 0; i < n; i++ ) {
            int elementsCount = scn.nextInt();
            int[] temp = new int[elementsCount];
            if (elementsCount > 0 ) {
                for (int j = 0; j < elementsCount; j++) {
                    temp[j] = scn.nextInt();
                }
                arrayList.add(temp);
            } else {
                arrayList.add(null);
            }
        }
        int qCount = scn.nextInt();
        ArrayList<int[]> queryList = new ArrayList<>();
        for (int i = 0; i < qCount; i++) {
            int[] temp = new int[2];
            for (int j = 0; j < 2; j++) {
                temp[j] = scn.nextInt();
            }
            queryList.add(temp);
        }
        scn.close();
        for (int[] a : queryList) {
            try {
                int[] temp = arrayList.get(a[0] - 1);
                System.out.println(temp[a[1] - 1]);
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}