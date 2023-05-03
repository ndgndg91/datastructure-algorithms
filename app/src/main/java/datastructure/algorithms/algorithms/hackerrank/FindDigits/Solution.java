package datastructure.algorithms.algorithms.hackerrank.FindDigits;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int result = 0;
        String strN = String.valueOf(n);
        String[] ns = strN.split("");
        for (int i = 0; i < ns.length; i++) {
            int nonZero = Integer.parseInt(ns[i]);
            if (nonZero == 0)
                continue;
            if(n % nonZero == 0)
                result++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            System.out.println(result);
        }
        scanner.close();
    }
}
