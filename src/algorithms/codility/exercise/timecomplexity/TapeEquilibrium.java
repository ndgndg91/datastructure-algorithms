package algorithms.codility.exercise.timecomplexity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Logger;

public class TapeEquilibrium {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        final var tapeEquilibrium = new TapeEquilibrium();
        int solution = tapeEquilibrium.solution(new int[]{0, 2000,0});
        logger.info("solution : " + solution);
    }

    public int solution(int[] A) {
        long sum = Arrays.stream(A).asLongStream().sum();
        final var tapes = new HashSet<Long>();
        var front = 0;
        for (int i = 1; i < A.length; i++) {
            front += A[i-1];
            var back = sum - front;
            tapes.add(Math.abs(front - back));
        }

        long min = tapes.stream().min(Long::compareTo).orElseThrow();
        return Math.toIntExact(min);
    }
}
