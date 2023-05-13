package datastructure.algorithms.algorithms.baemin;

import java.util.Arrays;

public class Solution1 {

    public String solution(String[] params) {
        return Arrays.stream(params)
                .map(String::toUpperCase)
                .filter(s -> s.length() >= 5 && s.length() <= 10)
                .findFirst()
                .orElse("없음");
    }
}
