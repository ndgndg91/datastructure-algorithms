package algorithms.hackerrank._30DaysOfCode.Day9;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the factorial function below.
    static int factorial(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return n * factorial(n-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);
        System.out.println(result);

        scanner.close();
    }
}
