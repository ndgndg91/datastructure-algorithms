package datastructure.algorithms.algorithms.codingtest.sixshop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SixShop1 {
    public static String isPangram(List<String> strings) {
        // Write your code here

        String ans = "";
        for(int i=0; i<strings.size(); i++) {
            String tmp = "1";
            for(int j=97; j<=122; j++) {
                int res = strings.get(i).indexOf((char) j);
                if(res == -1) {
                    tmp = "0";
                    break;
                }
            }
            ans += tmp;
        }
        return ans;
    }

    static String usingSet(List<String> strings) {
        StringBuilder ans = new StringBuilder();
        for (String s : strings) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
//            System.out.println(set.size());
            if (set.size() == 27)
                ans.append("1");
            else
                ans.append("0");

        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String case1 = "we promptly judged antique ivory buckles for the next prize";
        String case2 = "we promptly judged antique ivory buckles for the prize";
        String case3 = "the quick brown fox jumps over the lazy dog";
        String case4 = "the quick brown fox jump over the lazy dog";
        List<String> strings = new ArrayList<>();
        strings.add(case1);
        strings.add(case2);
        strings.add(case3);
        strings.add(case4);
//        String result = isPangram(strings);
        String result2 = usingSet(strings);

//        System.out.println(result);
        System.out.println(result2);
    }

}



