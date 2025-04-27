package datastructure.algorithms.algorithms.neetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DuplicateInteger {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }
}
