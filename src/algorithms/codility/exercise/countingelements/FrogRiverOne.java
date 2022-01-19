package algorithms.codility.exercise.countingelements;

import java.util.HashSet;
import java.util.logging.Logger;

public class FrogRiverOne {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args){
        final var frogRiverOne = new FrogRiverOne();
        int solution = frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        logger.info("solution : " + solution);

        int solution2 = frogRiverOne.solution(2, new int[]{2, 2, 2, 2, 2});
        logger.info("solution : " + solution2);
    }

    public int solution(int X, int[] A) {
        final var s = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            s.add(A[i]);

            if (s.size() == X) {
                return i;
            }
        }

        return -1;
    }
}
