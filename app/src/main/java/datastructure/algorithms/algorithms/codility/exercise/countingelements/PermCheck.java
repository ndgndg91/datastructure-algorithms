package datastructure.algorithms.algorithms.codility.exercise.countingelements;

import java.util.Arrays;
import java.util.logging.Logger;

public class PermCheck {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        final var permCheck = new PermCheck();
        int solution = permCheck.solution(new int[]{1, 3, 4, 2});
        logger.info("solution : " + solution);
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int a = 1;
        for (int j : A) {
            if (j != a++) return 0;
        }

        return 1;
    }
}
