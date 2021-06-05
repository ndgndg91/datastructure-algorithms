package algorithms.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = SumOfK.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }
}
