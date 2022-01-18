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
        int sum = (A.length + 1) * (A.length + 1 + 1) / 2;
        logger.info("sum : " + sum);
        int reduce = Arrays.stream(A).reduce(0, Integer::sum);
        logger.info("reduce : " + reduce);
        return sum - reduce;
    }
}
