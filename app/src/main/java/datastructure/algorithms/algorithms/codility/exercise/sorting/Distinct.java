package datastructure.algorithms.algorithms.codility.exercise.sorting;

import java.util.HashSet;

public class Distinct {

    public static void main(String[] args) {
        final var distinct = new Distinct();
        int solution = distinct.solution(new int[]{1, 1, 3, 3, 4, 4, 2});
        System.out.println(solution);
    }

    public int solution(int[] A) {
        final var s = new HashSet<Integer>();
        for (var v : A) {
            s.add(v);
        }

        return s.size();
    }
}
