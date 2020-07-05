package algorithms.codingtest.sixshop;

import java.util.LinkedList;
import java.util.List;

public class SixShop3 {


    static void test() {
        List<Integer> p = new LinkedList<>();
        int[] arr = {-5,4,-2,3,1,-1,-6,-1,0,-5};
        int[] arr2 = {-5, 4, -2, 3, 1};
        for(int i=0; i<arr2.length; i++) {
            p.add(arr2[i]);
        }

        System.out.println(minPower(p));
    }

    public static void main(String[] args) {
        test();
    }

    public static int minPower(List<Integer> p) {
        // Write your code here
        int[] arr;
        int min = Integer.MAX_VALUE;
        int num, ans, current = 0;
        int index =0;
        num = p.size();

        arr = new int[num];

        for(int i=0; i<num; i++) {
            arr[i] = p.get(index++);
        }

        for(int i=0; i<num; i++) {
            current += arr[i];
            min = Integer.min(min, current);
            System.out.println("current : " + current+ "\t min : "+min );
        }

        if(min >= 1) {
            return 0;
        } else {
            ans = min*-1;
            ans+=1;

            return ans;
        }
    }
}