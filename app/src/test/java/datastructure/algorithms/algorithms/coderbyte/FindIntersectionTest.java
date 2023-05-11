package datastructure.algorithms.algorithms.coderbyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindIntersectionTest {

    @Test
    void findIntersection() {
        // given
        String[] firstArgs = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        String[] secondArgs = {"1,3", "4,5"};
        String[] thirdArgs = {"5, 6, 9, 11, 12, 16", "4, 6, 7, 11, 16"};

        // when
        var firstResult = FindIntersection.findIntersection(firstArgs);
        var secondResult = FindIntersection.findIntersection(secondArgs);
        var thirdResult = FindIntersection.findIntersection(thirdArgs);

        // then
        assertEquals("1,4,13", firstResult);
        assertEquals("false", secondResult);
        assertEquals("6,11,16", thirdResult);
    }

}