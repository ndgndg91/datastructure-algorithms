package datastructure.algorithms.algorithms.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        for (var i : new TopKFrequentElements().topKFrequent2(new int[]{1, 2, 2, 2, 3, 3}, 2)) {
            System.out.println(i);
        }
        for (var i : new TopKFrequentElements().topKFrequent2(new int[]{7,7}, 1)) {
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

    public int[] topKFrequent2(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create bucket sort array where index is frequency
        // The maximum frequency possible is the length of the array
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Put numbers in buckets based on their frequency
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num);
        }

        // Step 4: Get top k frequent elements by going from highest frequency buckets
        int[] result = new int[k];
        int resultIndex = 0;

        for (int i = buckets.length - 1; i >= 0 && resultIndex < k; i--) {
            List<Integer> bucket = buckets[i];
            for (int num : bucket) {
                if (resultIndex < k) {
                    result[resultIndex++] = num;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
