package algorithms.hackerrank.BeautifulDaysatTheMovie;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        for (int startDay = i; startDay <= j; startDay++) {
            String day = String.valueOf(startDay);
            String[] arr = day.split("");
            StringBuilder builder = new StringBuilder();
            for (int a = arr.length-1; a > -1; a--){
                builder.append(arr[a]);
            }
            int reverse = Integer.parseInt(builder.toString());
            if(Math.abs(startDay - reverse) % k == 0)
                beautifulDays++;
        }
        return beautifulDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        scanner.close();
    }
}
