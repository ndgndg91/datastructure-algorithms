package datastructure.algorithms.algorithms.neetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{2,20,4,10,3,4,5}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0,3,2,5,4,6,1,1}));
    }

    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }
        var longest = 1;
        for (var num : nums) {
            if (!set.contains(num - 1)) {
                var length = 1;
                while (set.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
