package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AvgValueInArrayTest {

    @Test
    void solution() {
        // given
        var avgValueInArray = new AvgValueInArray();

        // when
        double solution = avgValueInArray.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        double solution1 = avgValueInArray.solution(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99});

        // then
        assertThat(solution).isEqualTo(5.5);
        assertThat(solution1).isEqualTo(94.0);
    }

}