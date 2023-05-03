package datastructure.algorithms.algorithms.codility.exercise.iterations;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    private static final Logger logger = Logger.getGlobal();
    private static final BinaryGap target = new BinaryGap();

    @Test
    void first() {
        //given
        final var $1 = 1073741825;

        //when
        final int $1solution = target.solution($1);

        //then
        logger.info("$1solution : " + $1solution);
    }

    @Test
    void second() {
        // given
        final var $2 =  16;

        // when
        int result = target.solution2($2);

        // then
        logger.info("second : " + result);
        assertEquals(0, result);
    }

}