package algorithms.codewars;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void test_BasicTests() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", RangeExtraction.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));

        assertEquals("-3--1,2,10,15,16,18-20", RangeExtraction.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));

        assertEquals("-11--8,-5,-2,0,1,3,4,7-9,11", RangeExtraction.rangeExtraction(new int[] {-11,-10,-9,-8,-5,-2,0,1,3,4,7,8,9,11}));
    }

    static String removeLastComma(String s) {
        int lastIndex = s.lastIndexOf(",");
        int last = s.length() - 1;
        if (lastIndex == last) {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }

    @Test
    public void basic() throws Exception {
        //given
        assertEquals("1,2,3,4,5", removeLastComma("1,2,3,4,5,"));
        //when

        //then
     }
}
