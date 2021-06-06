package algorithms.codewars;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        return sumOfCombinations(ls, k).stream().filter(s -> s <= t).max(Integer::compare).orElse(null);
    }

    static List<Integer> sumOfCombinations(List<Integer> target, int depth) {
        return doRecursive(0, new int[depth], 0, target, depth, new ArrayList<>());
    }

    static List<Integer> doRecursive(int index, int[] arr, int start, List<Integer> target, int depth, List<Integer> sums) {
        if (index == depth) {
            int sum = 0;
            for (int j : arr) {
                sum += j;
            }

            sums.add(sum);
            return sums;
        }

        for (var i = start; i < target.size(); i++) {
            arr[index] = target.get(i);
            doRecursive(index+1 , arr,i + 1, target, depth, sums);
        }

        return sums;
    }
}
