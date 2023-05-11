package datastructure.algorithms.algorithms.coderbyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestWordTest {

    @Test
    void longestWord() {
        // given
        var firstSen = "fun&!! time";
        var secondSen = "i love you!";
        var thirdSen = "123456789 98765432";
        var fourthSen = "a confusing /:sentence:/[ this is not!!!!!!!~";

        // when
        var firstResult = LongestWord.longestWord(firstSen);
        var secondResult = LongestWord.longestWord(secondSen);
        var thirdResult = LongestWord.longestWord(thirdSen);
        var fourthResult = LongestWord.longestWord(fourthSen);

        // then
        assertEquals("time", firstResult);
        assertEquals("love", secondResult);
        assertEquals("123456789", thirdResult);
        assertEquals("confusing", fourthResult);
    }

}