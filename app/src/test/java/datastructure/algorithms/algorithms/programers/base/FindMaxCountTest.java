package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaxCountTest {

    @Test
    void find() {
        FindMaxCount findMaxCount = new FindMaxCount();

        int solution = findMaxCount.solution(new int[]{1, 2, 3, 3, 3, 4});
        int solution1 = findMaxCount.solution(new int[]{1, 1, 2, 2});

        assertEquals(3, solution);
        assertEquals(-1, solution1);
    }

}