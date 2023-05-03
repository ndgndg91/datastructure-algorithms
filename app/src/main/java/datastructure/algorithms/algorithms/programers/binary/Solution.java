package datastructure.algorithms.algorithms.programers.binary;

public class Solution {

    public static void main(String[] args) {
        int n = 15;
        int biggerNWithSameBigCount = getBiggerNWithSameBigCount(n);
        System.out.println(biggerNWithSameBigCount);
    }

    private static int getBiggerNWithSameBigCount(int n){
        int bitCount = Integer.bitCount(n);
        int answer = n;
        for (int i = n+1; i < n * 2; i++) {
            if (bitCount == Integer.bitCount(i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
