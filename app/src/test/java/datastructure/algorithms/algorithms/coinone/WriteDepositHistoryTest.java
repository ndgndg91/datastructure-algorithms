package datastructure.algorithms.algorithms.coinone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WriteDepositHistoryTest {

    @Test
    void test_solution() {
        // given
        WriteDepositHistory history = new WriteDepositHistory();

        // when
        var first = history.solution(new int[]{500, 1000, -300, 200, -400, 100, -100});
        var second = history.solution(new int[]{500, 1000, 2000, -1000, -1500, 500});

        // then
        assertThat(first).isEqualTo(new int[]{500, 500});
        assertThat(second).isEqualTo(new int[]{500, 500, 500});
    }
}