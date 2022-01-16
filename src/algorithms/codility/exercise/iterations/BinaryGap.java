package algorithms.codility.exercise.iterations;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BinaryGap {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        //given
        final BinaryGap binaryGap = new BinaryGap();
        final var $1 = 1073741825;

        //when
        final int $1solution = binaryGap.solution($1);

        //then
        logger.info("$1solution : " + $1solution);
    }

    int solution(int N) {
        final String s = Integer.toBinaryString(N);
        logger.info(s);
        List<Character> zeros = new ArrayList<>();
        List<Character> ones = new ArrayList<>();
        int max = 0;
        for (var t : s.toCharArray()) {
            if (t == '1') {
                ones.add(t);
            } else {
                zeros.add(t);
            }

            if (ones.size() == 2) {
                if (max <= zeros.size()) {
                    max = zeros.size();
                }

                zeros.clear();
                ones.remove(ones.size() - 1);
            }
        }

        return max;
    }

}
