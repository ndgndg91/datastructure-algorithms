package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SharePizza3Test {

    @Test
    void solution() {
        // given
        var sharePizza3 = new SharePizza3();

        // when
        int solution = sharePizza3.solution(7, 10);
        int solution1 = sharePizza3.solution(4, 12);

        // then
        assertThat(solution).isEqualTo(2);
        assertThat(solution1).isEqualTo(3);
    }

}