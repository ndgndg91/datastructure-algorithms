package datastructure.algorithms.algorithms.coderbyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestWordTest {

    @Test
    void longestWord() {
        // given

        // when
        var time = LongestWord.longestWord("fun&!! time");
        var love = LongestWord.longestWord("i love123 you453457!");

        // then
        assertEquals(time, "time");
        assertEquals(love, "love");
    }

}