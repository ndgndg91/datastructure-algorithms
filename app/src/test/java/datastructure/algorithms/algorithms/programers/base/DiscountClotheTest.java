package datastructure.algorithms.algorithms.programers.base;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountClotheTest {

    @Test
    void solution() {
        // given
        var discountClothe = new DiscountClothe();

        // when
        int solution = discountClothe.solution(150000);
        int solution1 = discountClothe.solution(580000);

        // then
        assertThat(solution).isEqualTo(142500);
        assertThat(solution1).isEqualTo(464000);
    }

}