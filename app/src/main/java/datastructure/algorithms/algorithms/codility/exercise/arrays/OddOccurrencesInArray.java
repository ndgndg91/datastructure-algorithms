package datastructure.algorithms.algorithms.codility.exercise.arrays;

import java.util.HashMap;
import java.util.logging.Logger;

public class OddOccurrencesInArray {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        final OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

        final int solution = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});

        logger.info("solution : " + solution);
    }

    public int solution(int[] A) {
        // write your code in Java SE 11
        final var counter = new HashMap<Integer, Integer>();
        for (var i : A) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        return counter.entrySet()
            .stream()
            .filter(e -> e.getValue() % 2 != 0)
            .findFirst()
            .orElseThrow()
            .getKey();
    }
}
