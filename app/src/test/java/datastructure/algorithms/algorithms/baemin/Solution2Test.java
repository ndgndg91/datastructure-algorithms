package datastructure.algorithms.algorithms.baemin;

import org.junit.jupiter.api.Test;

class Solution2Test {

    @Test
    void first() {
        Solution2 solution2 = new Solution2();

        String solution = solution2.solution(new String[]{"a", "b", "c"}, new String[]{"b", "c", "d"});

        System.out.println(solution);
    }

    @Test
    void second() {
        Solution2 solution2 = new Solution2();

        String solution = solution2.solution(new String[]{"a","b","b"}, new String[]{"b","c","d"});

        System.out.println("second : " + solution);
    }

    @Test
    void none() {
        Solution2 solution2 = new Solution2();

        String solution = solution2.solution(new String[]{"a", "b","c"}, new String[]{"d","e","f"});

        System.out.println("nonce : " + solution);
    }

}