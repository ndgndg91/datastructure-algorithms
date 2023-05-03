package datastructure.algorithms.algorithms.hackerrank.RepeatedString;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        boolean[] aInfo = new boolean[s.length()];
        int aCntInStr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 97) {
                aInfo[i] = true;
                aCntInStr++;
            }
        }
        long strLength = s.length();
        long repeatedCnt = n / strLength;
        long leftLength = n % strLength;

        long aEmergence = aCntInStr * repeatedCnt;
        for (int i = 0; i < leftLength; i++) {
            if (aInfo[i])
                aEmergence++;
        }
        return aEmergence;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

        scanner.close();
    }
}
