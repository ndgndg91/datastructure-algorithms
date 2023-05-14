package datastructure.algorithms.algorithms.programers.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FindMaxCount {

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(a -> map.put(a, map.getOrDefault(a, 0) + 1));

        AtomicBoolean isMultipleFrequency = new AtomicBoolean(false);
        AtomicInteger maxKey = new AtomicInteger();
        AtomicInteger maxValue = new AtomicInteger(0);
        map.forEach((k,v) -> {
            if (v > maxValue.get()) {
                maxValue.set(v);
                maxKey.set(k);
                isMultipleFrequency.set(false);
            } else if (v == maxValue.get()) {
                isMultipleFrequency.set(true);
            }
        });

        if (isMultipleFrequency.get()) {
            return -1;
        } else {
            return maxKey.intValue();
        }
    }
}
