package datastructure.algorithms.algorithms.codewars;

import java.util.ArrayList;
import java.util.List;

public class SumOfK {

    static List<Integer> combinationUtil(int[] arr, int[] data, int start,
                                int end, int index, int r, List<Integer> sums)
    {
        if (index == r)
        {
            var sum = 0;
            for (var j=0; j<r; j++) {
                sum += data[j];
            }
            sums.add(sum);
            return sums;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r, sums);
        }

        return sums;
    }

    static List<Integer> distanceSums(int[] arr, int n, int r)
    {
        var data = new int[r];

        return combinationUtil(arr, data, 0, n - 1, 0, r, new ArrayList<>());
    }

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        if (ls.size() < k) {
            return null;
        }

        int[] arr = new int[ls.size()];
        for (var i = 0; i < ls.size(); i++) {
            arr[i] = ls.get(i);
        }

        return distanceSums(arr, arr.length, k).stream().filter(sum -> sum <= t).max(Integer::compare).orElse(null);
    }
}
