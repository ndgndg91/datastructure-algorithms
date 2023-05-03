package datastructure.algorithms.algorithms.hackerrank.DrawingBook;

import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int result = 0;
        if(n-p > Math.abs(0-p)){ //앞에서 부터
            result = Math.abs(0-p)/2;
        } else { //뒤에서 부터
            result = (n-p)/2;
            if ( n > 2 && n % 2 == 0 && n-p == 1)
                result+=1;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);
        System.out.println(result);

        scanner.close();
    }
}
