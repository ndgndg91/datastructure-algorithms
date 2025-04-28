package datastructure.algorithms.algorithms.neetcode;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        for (var i : new TopKFrequentElements().topKFrequent(new int[]{1, 2, 2, 2, 3, 3}, 2)) {
            System.out.println(i);
        }
        for (var i : new TopKFrequentElements().topKFrequent(new int[]{7,7}, 1)) {
            System.out.println(i);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (var n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
