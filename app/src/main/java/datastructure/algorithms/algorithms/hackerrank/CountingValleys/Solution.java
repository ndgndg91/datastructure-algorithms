package datastructure.algorithms.algorithms.hackerrank.CountingValleys;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        String[] ud = s.split("");
        int[] altitudes = new int[ud.length];
        int altitude = 0;
        for (int i = 0; i < ud.length; i++) {
            if ("U".equals(ud[i]))
                altitude++;
            if ("D".equals(ud[i]))
                altitude--;
            altitudes[i] = altitude;
        }
        int result = 0;
        for (int i = 0; i < altitudes.length; i++) {
            if (altitudes[i] == 0)
                if (altitudes[i-1] < 0)
                    result++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        int result = countingValleys(n, s);
        System.out.println(result);

        Integer[] list = {1, 3, 5, 7};
        Arrays.sort(list, Collections.reverseOrder());
        for (int i = 0 ; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        scanner.close();
    }
}
