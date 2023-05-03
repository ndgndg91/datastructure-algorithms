package datastructure.algorithms.algorithms.hackerrank.SequenceEquation;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] firstCache = new int[p.length+1];
        int[] result = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            firstCache[p[i]] = i+1;
        }
        for (int i = 1; i < firstCache.length; i++) {
            result[i-1] = firstCache[firstCache[i]];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }
        scanner.close();
    }
}
