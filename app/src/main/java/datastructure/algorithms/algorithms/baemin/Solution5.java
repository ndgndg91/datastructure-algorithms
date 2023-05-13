package datastructure.algorithms.algorithms.baemin;

import java.util.*;

public class Solution5 {
    public int[] solution(int[] card) {
        Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(card).forEach(c -> counter.put(c, counter.getOrDefault(c, 0) + 1));

        List<Integer> answer = new ArrayList<>();
        counter.forEach((k,v) -> {
            if (v < 2) {
                answer.add(k);
            }
        });

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
