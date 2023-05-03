package datastructure.algorithms.algorithms.codingtest.ya;

import java.util.Arrays;

public class PairWise {

    public static void main(String[] args) {
        PairWise pairWise = new PairWise();
        int solution = pairWise.solution(new int[]{1,2,1});
        int solution1 = pairWise.solution(new int[]{2, 1, 4, 4});
        int solution2 = pairWise.solution(new int[]{6, 2, 3, 5, 6, 3});
        int solution3 = pairWise.solution(new int[]{10,2,3,4,5,6,7,8,9,10});

        System.out.println("must be 2 : " + solution);
        System.out.println("must be 1 : " + solution1);
        System.out.println("must be 4 : " + solution2);
        System.out.println("must be 9 : " + solution3);
    }
    public int solution(int[] A) {
        // write your code in Java SE 11
        long parameterSum = Arrays.stream(A).asLongStream().sum();
        long rightSum = ((long) A.length * (A.length + 1)) / 2;

        return (int) Math.abs(parameterSum - rightSum);
    }
}
