package datastructure.algorithms.algorithms.programers.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class LifeBoat {
    private static final int[] personWeights = {70, 50, 80, 50};
    private static final int maximumWeightOfBoat = 100;
    private static final int result = 3;

    private static final int[] personWeights2 = {40, 240, 240, 50, 60, 240, 200};
    private static final int maximumWeightOfBoat2 = 240;
    private static final int result2 = 5;

    public static void main(String[] args) {
        int solution = solution(personWeights2, maximumWeightOfBoat2);
        System.out.println(solution);
    }

    private static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> peopleWeights = Arrays.stream(people)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int left = 0;
        int right = peopleWeights.size() - 1;

        while (left < right) {
            int sum = peopleWeights.get(left) + peopleWeights.get(right);
            if (sum <= limit) {
                left++;
                right--;
            } else {
                left++;
            }

            answer++;
        }

        if (left == right) answer++;
        return answer;
    }
}
