package datastructure.algorithms.algorithms.codility.exercise.timecomplexity;

import java.util.logging.Logger;

public class FrogJmp {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        int solution = frogJmp.solution(10, 85, 30);
        logger.info("solution : " + solution);
        logger.info("" + 75 % 30);
    }

    private int solution(int X, int Y, int D) {
        if ((Y - X) % D > 0) {
            return ((Y - X) / D) + 1;
        }
        return (Y - X) / D;
    }
}
