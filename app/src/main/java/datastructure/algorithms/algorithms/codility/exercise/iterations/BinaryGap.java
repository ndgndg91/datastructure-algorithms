package datastructure.algorithms.algorithms.codility.exercise.iterations;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BinaryGap {

    int solution(int N) {
        final String s = Integer.toBinaryString(N);
        List<Character> zeros = new ArrayList<>();
        List<Character> ones = new ArrayList<>();
        int max = 0;
        for (var t : s.toCharArray()) {
            if (t == '1') {
                ones.add(t);
            } else {
                zeros.add(t);
            }

            if (ones.size() == 2) {
                if (max <= zeros.size()) {
                    max = zeros.size();
                }

                zeros.clear();
                ones.remove(ones.size() - 1);
            }
        }

        return max;
    }

    int solution2(int N) {
        // write your code in Java SE 8
        String s = Integer.toBinaryString(N);

        //when
        int count = 0;
        int length = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') count++;
            if (s.charAt(i) == '1') {
                length = Math.max(length, count);
                count = 0;
            }
        }

        return length;
    }

}