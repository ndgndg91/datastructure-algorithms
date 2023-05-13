package datastructure.algorithms.algorithms.baemin;

import java.util.Arrays;
import java.util.HashSet;

public class Solution2 {

    public String solution(String[] leftArray, String[] rightArray) {
        HashSet<String> left = new HashSet<>(Arrays.asList(leftArray));
        HashSet<String> right = new HashSet<>(Arrays.asList(rightArray));
        left.retainAll(right);
        return String.join(",", left);
    }
}
