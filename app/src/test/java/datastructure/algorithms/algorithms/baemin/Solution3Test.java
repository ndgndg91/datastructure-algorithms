package datastructure.algorithms.algorithms.baemin;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution3Test {

    @Test
    void solution3() {
        Solution3 solution3 = new Solution3();

        String[] solution = solution3.solution(new String[]{}, new String[]{});

        System.out.println(Arrays.toString(solution));
    }

}