package datastructure.algorithms.algorithms.codility.exercise.countingelements;

import java.util.HashSet;

public class MissingInteger {
    public static void main(String[] args) {
        final var missingInteger = new MissingInteger();
        final var solution = missingInteger.solution(new int[]{-1, -2, -3});
        System.out.println(solution);
    }

    public int solution(int[] A) {
        final var integers = new HashSet<Integer>();
        for (var v : A) {
            integers.add(v);
        }

        for (int i = 1; i <= 1_000_000; i++) {
            if (!integers.contains(i)) return i;
        }
        return -1;
    }
}
