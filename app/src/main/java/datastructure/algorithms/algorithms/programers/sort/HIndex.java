package datastructure.algorithms.algorithms.programers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex {

    private static final int[] array = {3, 0, 6, 1, 5};
    private static final int result = 3;

    public static void main(String[] args) {
        int solution = solution(array);
        System.out.println(solution);
    }

    private static int solution(int[] citations) {
        List<Integer> reversedCitations = Arrays.stream(citations).boxed()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (reversedCitations.get(i) >= i+1) hIndex++;
            else break;
        }

        return hIndex;
    }


}
