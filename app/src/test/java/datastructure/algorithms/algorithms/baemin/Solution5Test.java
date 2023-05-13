package datastructure.algorithms.algorithms.baemin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution5Test {

    @Test
    void solution5() {
        Solution5 solution5 = new Solution5();

        int[] solution = solution5.solution(new int[]{1, 3, 2, 5, 3, 1});
        int[] solution1 = solution5.solution(new int[]{1, 2, 3, 4, 4, 3, 2, 5});

        assertArrayEquals(new int[]{2,5}, solution);
        assertArrayEquals(new int[]{1,5}, solution1);
    }

}