package datastructure.algorithms.algorithms.hackerrank._30DaysOfCode.Day14;

import java.util.*;

class Difference {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    public Difference(int[] elements) {
        this.elements = elements;
    }
    public void computeDifference(){
        int maxDiff = 0;
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = i+1; j < this.elements.length; j++) {
                maxDiff = Math.max(Math.abs(this.elements[i] - this.elements[j]),maxDiff);
            }
        }
        this.maximumDifference = maxDiff;
    }

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}