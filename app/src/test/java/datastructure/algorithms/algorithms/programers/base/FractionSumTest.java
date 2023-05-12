package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionSumTest {

    @Test
    void solution() {
        FractionSum fractionSum = new FractionSum();

        int[] solution = fractionSum.solution(1, 2, 3, 4);

        assertEquals(5, solution[0]);
        assertEquals(4, solution[1]);
    }

}