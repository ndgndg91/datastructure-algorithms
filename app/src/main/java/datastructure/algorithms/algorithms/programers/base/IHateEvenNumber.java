package datastructure.algorithms.algorithms.programers.base;

import java.util.ArrayList;
import java.util.List;

public class IHateEvenNumber {

    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) answer.add(i);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
