package datastructure.algorithms.algorithms.coderbyte;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {

    // 숫자 제거
    // 특문 제거
    // 같은 길이 2개 이상 시 첫번째것
    public static String longestWord(String sen) {
        // code goes here
         return Arrays.stream(sen.split(" "))
                .map(word -> word.replaceAll("[/:!@#$%^&*()]", ""))
                .max(Comparator.comparingInt(String::length)).orElseThrow();
    }
}
