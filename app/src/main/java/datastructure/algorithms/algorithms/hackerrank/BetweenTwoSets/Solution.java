package datastructure.algorithms.algorithms.hackerrank.BetweenTwoSets;

import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        int cnt = 0;
        long lcm = lcm(a);
        long gcd = gcd(b);
        if(lcm > gcd)
            return 0;
        for(long i = lcm; i <= gcd; i++){
            int aCnt = 0;
            for(int aa = 0; aa < a.length; aa++) {
                if(i % a[aa] == 0)
                    aCnt++;
            }
            int bCnt = 0;
            for(int bb = 0; bb < b.length; bb++) {
                if(b[bb] % i == 0)
                    bCnt++;
            }
            if(aCnt == a.length && bCnt == b.length)
                cnt++;
        }
        return cnt;
    }
    private static long gcd(int[] arr){
        long result = 0;
        if (arr.length > 1){
            long gcd = gcd(arr[0], arr[1]);
            for (int i = 2; i < arr.length; i++){
                gcd = gcd(arr[i], gcd);
            }
            result = gcd;
        }  else {
            result = arr[0];
        }
        return result;
    }

    private static long gcd(long a, long b) {
        long number1, number2;
        long remain = 1;

        if(a>b){
            number1 = a;
            number2 = b;
        }
        else{
            number1 = b;
            number2 = a;
        }
        while(remain>0){ // 유클리드 호제법
            remain = number1%number2;
            number1 = number2;
            number2 = remain;
        }

        return number1; //최대공약수
    }

    private static long lcm(int[] arr){
        long result = 1;
        if (arr.length > 1){
            long lcm = lcm(arr[0], arr[1], gcd(arr[0], arr[1]));
            for (int i = 2; i < arr.length; i++){
                lcm = lcm(lcm, arr[i], gcd(lcm, arr[i]));
            }
            result = lcm;
        }  else {
            result = arr[0];
        }
        return result;
    }

    private static long lcm(long a, long b, long gcd){
        return a*b / gcd;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
