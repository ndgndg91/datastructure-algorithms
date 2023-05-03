package datastructure.algorithms.algorithms.hackerrank._30DaysOfCode.Day6;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int strCnt = scn.nextInt();
        String[] words = new String[strCnt];
        for (int i = 0; i < strCnt; i++) {
            words[i] = scn.next();
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                if (j % 2 == 0)
                    even.append(words[i].charAt(j));
                else
                    odd.append(words[i].charAt(j));
            }
            System.out.println(even.toString() + " " + odd.toString());
        }
    }
}

