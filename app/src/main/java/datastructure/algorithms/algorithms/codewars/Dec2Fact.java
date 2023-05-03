package datastructure.algorithms.algorithms.codewars;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Dec2Fact {
    static Map<Long, String> dict = new HashMap<>();

    static {
        dict.put(10L, "A");
        dict.put(11L, "B");
        dict.put(12L, "C");
        dict.put(13L, "D");
        dict.put(14L, "E");
        dict.put(15L, "F");
        dict.put(16L, "G");
        dict.put(17L, "H");
        dict.put(18L, "I");
        dict.put(19L, "J");
        dict.put(20L, "K");
        dict.put(21L, "L");
        dict.put(22L, "M");
        dict.put(23L, "N");
        dict.put(24L, "O");
        dict.put(25L, "P");
        dict.put(26L, "Q");
        dict.put(27L, "R");
        dict.put(28L, "S");
        dict.put(29L, "T");
        dict.put(30L, "U");
        dict.put(31L, "V");
        dict.put(32L, "W");
        dict.put(33L, "X");
        dict.put(34L, "Y");
        dict.put(35L, "Z");
    }

    static Map<String, Long> digitFinder = new HashMap<>();

    static {
        digitFinder.put("A", 10L);
        digitFinder.put("B", 11L);
        digitFinder.put("C", 12L);
        digitFinder.put("D", 13L);
        digitFinder.put("E", 14L);
        digitFinder.put("F", 15L);
        digitFinder.put("G", 16L);
        digitFinder.put("H", 17L);
        digitFinder.put("I", 18L);
        digitFinder.put("J", 19L);
        digitFinder.put("K", 20L);
        digitFinder.put("L", 21L);
        digitFinder.put("M", 22L);
        digitFinder.put("N", 23L);
        digitFinder.put("O", 24L);
        digitFinder.put("P", 25L);
        digitFinder.put("Q", 26L);
        digitFinder.put("R", 27L);
        digitFinder.put("S", 28L);
        digitFinder.put("T", 29L);
        digitFinder.put("U", 30L);
        digitFinder.put("V", 31L);
        digitFinder.put("W", 32L);
        digitFinder.put("X", 33L);
        digitFinder.put("Y", 34L);
        digitFinder.put("Z", 35L);
    }

    public static String dec2FactString(long nb) {
        var result = new ArrayDeque<String>();
        var dividend = 1;
        while (nb > 0) {
            var reminder = nb % dividend;
            nb = nb / dividend;
            var e = String.valueOf(reminder);
            if (reminder > 9) {
                e = dict.get(reminder);
            }
            result.addFirst(e);
            dividend++;
        }

        return String.join("", result);
    }

    public static long factString2Dec(String str) {
        String[] arr = str.split("");
        long sum = 0;
        for (var i = 0; i < arr.length; i++) {
            sum += factorialValue(arr.length - i - 1, arr[i]);
        }

        return sum;
    }

    static long factorialValue(int factorial, String value) {
        try {
            return Integer.parseInt(value) * factorial(factorial);
        } catch (NumberFormatException e) {
            return digitFinder.get(value) * factorial(factorial);
        }
    }

    static long factorial(int value) {
        if (value == 0) {
            return 0;
        }

        if (value == 1) {
            return 1;
        }

        return value * factorial(value - 1);
    }


}
