package datastructure.algorithms.algorithms.coinone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrinterTest {

    @Test
    void test_solution() {
        // given
        var printer = new Printer();
        var firstInput = new int[][]{{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
        var secondInput = new int[][]{{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};
        var thirdInput = new int[][]{{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};

        // when
        var first = printer.solution(firstInput);
        var second = printer.solution(secondInput);
        var third = printer.solution(thirdInput);

        // then
        assertThat(first).isEqualTo(new int[]{1, 3, 4, 2, 5});
        assertThat(second).isEqualTo(new int[]{1, 3, 2, 4, 5});
        assertThat(third).isEqualTo(new int[]{1, 2, 4, 5, 3});
    }

}