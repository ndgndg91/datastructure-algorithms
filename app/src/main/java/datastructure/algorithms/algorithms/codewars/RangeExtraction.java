package datastructure.algorithms.algorithms.codewars;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {
        Set<String> tokens = new LinkedHashSet<>();
        List<Integer> ranges = new LinkedList<>();
        for (var i = 0; i < arr.length; i++) {
            if (ranges.isEmpty()) {
                ranges.add(arr[i]);
            } else {
                if (ranges.get(ranges.size() - 1) + 1 == arr[i]) {
                    ranges.add(arr[i]);
                } else {
                    if (ranges.size() > 2) {
                        tokens.add(ranges.get(0) + "-" + ranges.get(ranges.size() - 1));
                    } else {
                        for (var num : ranges) {
                            tokens.add(String.valueOf(num));
                        }
                    }
                    ranges.clear();
                    ranges.add(arr[i]);
                }
            }
        }

        if (ranges.size() > 2) {
            tokens.add(ranges.get(0) + "-" + ranges.get(ranges.size() - 1));
        } else {
            for (var num : ranges) {
                tokens.add(String.valueOf(num));
            }
        }

        return String.join(",", tokens);
    }

    static String removeLastComma(String s) {
        int lastIndex = s.lastIndexOf(",");
        int last = s.length() - 1;
        if (lastIndex == last) {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }
}
