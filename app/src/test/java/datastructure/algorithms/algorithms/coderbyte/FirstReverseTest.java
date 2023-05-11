package datastructure.algorithms.algorithms.coderbyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstReverseTest {


    @Test
    void firstReverse() {
        // given
        var param = "abcdef";

        // when
        var result = FirstReverse.firstReverse(param);

        // then
        assertEquals(result, "fedcba");
    }

}