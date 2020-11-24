package algorithms.codingtest.st11;

import java.util.*;

public class MaxSum {
    // 3.5 초
    public static int findMaxSum(List<Integer> list) {
        if (list.isEmpty()) return 0;
        if (list.size() == 1) return list.get(0);

        int first = Integer.MIN_VALUE;
        for (int el : list) {
            if (el > first) {
                first = el;
            }
        }

        int second = 0;
        for (int el : list) {
            if (el < first && el > second) {
                second = el;
            }
        }

        return first + second;
    }

    // 21.5초
    public static int findMaxSum3(List<Integer> list) {
        if (list.isEmpty()) return 0;
        if (list.size() == 1) return list.get(0);

        PriorityQueue<Integer> queue = new PriorityQueue<>(list.size(), Collections.reverseOrder());
        queue.addAll(list);

        return queue.poll() + queue.poll();
    }

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            list.add(i);
        }

        System.out.println(findMaxSum3(list));
        System.out.println(System.currentTimeMillis() - start);
    }

    // 4초
    public static int findMaxSum2(List<Integer> list) {
        if (list.isEmpty()) return 0;
        if (list.size() == 1) return list.get(0);
        list.sort(Collections.reverseOrder());

        return list.get(0) + list.get(1);
    }
}