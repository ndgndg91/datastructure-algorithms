package algorithms.codility.exercise.timecomplexity;

import java.util.Arrays;
import java.util.logging.Logger;

public class PermMissingElem {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();

        int solution = permMissingElem.solution(new int[]{2, 3, 1, 5});
        logger.info("solution : " + solution);
    }

    public int solution(int[] A) {
        long sum = (long) (A.length + 1) * (A.length + 1 + 1) / 2;
        logger.info("sum : " + sum);
        long reduce = Arrays.stream(A).asLongStream().reduce(0, Long::sum);
        logger.info("reduce : " + reduce);
        return (int) (sum - reduce);
    }
}
