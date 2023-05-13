package datastructure.algorithms.algorithms.baemin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution4Test {

    @Test
    void solution4() {
        Solution4 solution4 = new Solution4();

        String solution = solution4.solution("/payment/1234/cancel");
        String solution1 = solution4.solution("");
        String solution2 = solution4.solution("");
        String solution3 = solution4.solution("");
        String solution5 = solution4.solution("");

        assertEquals("/payment/cancel?paymentId=1234", solution);
        assertEquals("error", solution1);
        assertEquals("error", solution2);
        assertEquals("error", solution3);
        assertEquals("error", solution5);

    }

}