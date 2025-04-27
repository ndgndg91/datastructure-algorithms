package datastructure.algorithms.algorithms.neetcode;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        var sMap = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        var tMap = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
