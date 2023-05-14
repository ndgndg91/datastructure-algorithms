package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharePizza2Test {

    @Test
    void solution() {
        SharePizza2 sharePizza2 = new SharePizza2();

        int solution1 = sharePizza2.solution(6);
        int solution2 = sharePizza2.solution(10);
        int solution3 = sharePizza2.solution(4);

        assertEquals(1, solution1);
        assertEquals(5, solution2);
        assertEquals(2, solution3);
    }

}