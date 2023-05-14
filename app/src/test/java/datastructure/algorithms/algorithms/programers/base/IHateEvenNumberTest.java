package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IHateEvenNumberTest {

    @Test
    void solution() {
        IHateEvenNumber iHateEvenNumber = new IHateEvenNumber();

        int[] solution = iHateEvenNumber.solution(10);

        assertArrayEquals(new int[]{1,3,5,7,9}, solution);
    }

}