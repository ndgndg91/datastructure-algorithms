package datastructure.algorithms.algorithms.hackerrank.NonDivisibleSubset;

import java.io.*;
import java.util.*;

public class Solution {
    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        if (k == 1){
            return 1;
        }
        int maxLength = 0;
        for (int idx = 0; idx < S.length; idx++) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = S[idx];
            list.add(temp);
            for (int i = 0; i < S.length; i++) {
                if (idx == i)
                    continue;
                if ((temp + S[i]) % k == 0)
                    continue;
                boolean flag = true;
                for (int a = 0; a < list.size(); a++) {
                    if((list.get(a) + S[i]) % k == 0)
                        flag = false;
                }
                if (flag) {
                    list.add(S[i]);
                }
            }
            System.out.println(list.size());
            maxLength = Math.max(maxLength, list.size());
        }
        return maxLength;
    }

    static int subsetPairNotDivisibleByK(int arr[],
                                         int N, int K)
    {

        // Array for storing frequency of modulo
        // values
        int f[] = new int[K];
        Arrays.fill(f, 0);

        // Fill frequency array with values modulo K
        for (int i = 0; i < N; i++)
            f[arr[i] % K]++;

        // if K is even, then update f[K/2]
        if (K % 2 == 0)
            f[K/2] = Math.min(f[K/2], 1);

        // Initialize result by minimum of 1 or
        // count of numbers giving remainder 0
        int res = Math.min(f[0], 1);

        // Choose maximum of count of numbers
        // giving remainder i or K-i
        for (int i = 1; i <= K/2; i++)
            res += Math.max(f[i], f[K-i]);

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);
        int result2 = subsetPairNotDivisibleByK(S, S.length, k);
        System.out.println("===================");
        System.out.println(result);
        System.out.println(result2);
        scanner.close();
    }
}
