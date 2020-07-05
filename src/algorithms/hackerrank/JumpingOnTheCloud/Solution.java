package algorithms.hackerrank.JumpingOnTheCloud;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int result = Integer.MAX_VALUE;
    static int jumCnt = -1;
    static int jumpingOnClouds(int[] c) {
        jumCnt(0, c.length, c);
        return  result;
    }

    static void jumCnt(int curIdx, int length, int[] cloud){
        if (curIdx >= length-1) {
            jumCnt++;
            result = Math.min(result, jumCnt);
            return;
        }
        if (cloud[curIdx] == 0) jumCnt++;
        if (cloud[curIdx] == 1) return;
        System.out.println(curIdx + " , " + jumCnt);

        jumCnt(curIdx + 2, length, cloud);
        jumCnt(++curIdx, length, cloud);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);

        scanner.close();
    }
}
