package datastructure.algorithms.algorithms.codility.exercise.arrays;

import java.util.logging.Logger;

public class CyclicRotation {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        //given
        final CyclicRotation cyclicRotation = new CyclicRotation();
        final int[] rotate = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 3);

        //when
        for (int i : rotate) {
            logger.info(i + "\t");
        }

        //then

        //verify
    }

    int[] rotate(int[] A, int K) {
        if (K % A.length == 0) return A;

        final int start = K % A.length;
        final int[] answer = new int[A.length];

        int oi = 0;
        for (int i = start; i < answer.length; i++) {
            answer[i] = A[oi++];
        }

        for (int i = 0; i < start; i++) {
            answer[i] = A[oi++];
        }

        return answer;
    }

}
