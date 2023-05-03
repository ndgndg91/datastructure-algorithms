package datastructure.algorithms.algorithms.hackerrank.SockMerchant;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer,Integer> socks = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if(null == socks.get(ar[i])){
                socks.put(ar[i], 1);
            } else {
                int cnt = socks.get(ar[i]);
                socks.put(ar[i], ++cnt);
            }
        }
        int pairCnt = 0;
        Iterator iterator = socks.keySet().iterator();
        while (iterator.hasNext()){
            Integer tempKey = (Integer)iterator.next();
            int cnt = socks.get(tempKey);
            pairCnt += cnt/2;
        }
        return pairCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

        scanner.close();
    }
}
