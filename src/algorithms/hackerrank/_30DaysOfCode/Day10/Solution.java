package algorithms.hackerrank._30DaysOfCode.Day10;

import java.util.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        String binaryString = Integer.toBinaryString(n);
        int consecutive = 0;
        int maxConsecutive = Integer.MIN_VALUE;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1')
                consecutive++;
            else
                consecutive = 0;
            maxConsecutive = Math.max(maxConsecutive, consecutive);
        }
        System.out.println(maxConsecutive);
    }
}
