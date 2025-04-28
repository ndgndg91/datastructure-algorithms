package datastructure.algorithms.algorithms.neetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        var skip = new ArrayList<Integer>();
        var result = new ArrayList<List<String>>();
        for (var i = 0; i < strs.length; i++) {
            if (skip.contains(i)) continue;
            skip.add(i);
            var group = new ArrayList<String>();
            group.add(strs[i]);
            var map = new HashMap<Character, Integer>();
            for (var c : strs[i].toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int j = i + 1; j < strs.length; j++) {
                var map2 = new HashMap<Character, Integer>();
                for (var c : strs[j].toCharArray()) {
                    map2.put(c, map2.getOrDefault(c, 0) + 1);
                }
                if (map.equals(map2)) {
                    group.add(strs[j]);
                    skip.add(j);
                }
            }
            result.add(group);
        }
        return result.stream().sorted(Comparator.comparingInt(List::size)).toList();
    }
}
