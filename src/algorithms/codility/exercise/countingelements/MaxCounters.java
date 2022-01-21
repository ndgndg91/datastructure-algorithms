package algorithms.codility.exercise.countingelements;

import java.util.Arrays;
import java.util.logging.Logger;

public class MaxCounters {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        final var maxCounters = new MaxCounters();
        int[] solution = maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        StringBuilder builder = new StringBuilder();
        for (int v : solution) {
            builder.append(v).append("\t");
        }

        logger.info(builder.toString());
    }

    /**
     * 성능 점수 통과
     */
    public int[] solution(int N, int[] A) {
        final var answer = new int[N];
        var max = 0;
        var maxCounter = 0;
        for (int v : A) {
            if (v > N) {
                maxCounter = max;
            }

            if (v >= 1 && v <= N) {
                if (answer[v-1] < maxCounter) {
                    answer[v-1] = maxCounter;
                }

                var temp = ++answer[v-1];
                if (temp >= max) {
                    max = temp;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] < maxCounter) {
                answer[i] = maxCounter;
            }
        }

        return answer;
    }

    /**
     * 성능 테스트 점수 낮음
     */
    public int[] lowSolution(int N, int[] A) {
        final var answer = new int[N];
        var max = 0;
        for (int j : A) {
            if (j >= 1 && j <= N) {
                var temp = ++answer[j-1];
                if (temp >= max) {
                    max = temp;
                }
            }

            if (j == N + 1) {
                logger.info("max : " + max);
                Arrays.fill(answer, max);
            }
        }

        return answer;
    }
}
