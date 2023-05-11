package datastructure.algorithms.algorithms.coderbyte;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindIntersection {
    public static String findIntersection(String[] strArr) {
        Set<Integer> first = Arrays.stream(strArr[0].split(","))
                .map(s -> Integer.parseInt(s.replaceAll(" ", "")))
                .collect(Collectors.toSet());
        Set<Integer> second = Arrays.stream(strArr[1].split(","))
                .map(s -> Integer.parseInt(s.replaceAll(" ", "")))
                .collect(Collectors.toSet());
        first.retainAll(second);
        if (first.size() > 0) {
            return first.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
        } else {
            return "false";
        }

    }
}
