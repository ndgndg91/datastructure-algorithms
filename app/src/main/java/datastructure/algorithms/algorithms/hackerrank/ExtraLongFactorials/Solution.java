package datastructure.algorithms.algorithms.hackerrank.ExtraLongFactorials;

import java.math.*;
import java.util.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigDecimal bigDecimal = new BigDecimal(n);
        BigDecimal result = factorial(bigDecimal);
        System.out.println(result.toString());
    }

    static BigDecimal factorial(BigDecimal n){
        if(n.longValue() <= 1)
            return n;
        return n.multiply(factorial(n.subtract(new BigDecimal(1))));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
