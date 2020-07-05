package algorithms.hackerrank.ViralAdvertising;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int people = 5;
        int like = people/2;
        if (n==1)
            return like;
        for (int i = 2; i <= n; i++){
            people = people/2 * 3;
            like += people/2;
        }
        return like;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);
        System.out.println(result);

        scanner.close();
    }
}
