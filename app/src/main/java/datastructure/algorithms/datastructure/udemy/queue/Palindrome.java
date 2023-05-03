package datastructure.algorithms.datastructure.udemy.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;

class Palindrome {

    public static boolean checkForPalindrome(String string) {
        var lowerCase = string.toLowerCase(Locale.ROOT);
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> queue = new LinkedList<>();

        for (var i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) >= 'a' && lowerCase.charAt(i) <= 'z') {
                stack.push(lowerCase.charAt(i));
                queue.add(lowerCase.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkPalindrome(String string) {
        var lowerCase = string.toLowerCase(Locale.ROOT);
        var list = new ArrayList<Character>();
        for (var c : lowerCase.toCharArray()) {
            if (c >= 'a' && c <= 'z'){
                list.add(c);
            }
        }

        var size = list.size();
        var start = 0;
        var mid = size / 2;
        var end = size - 1;
        while (start < mid || end > mid) {
            var front = list.get(start);
            var back = list.get(end);
            if (!front.equals(back)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
    
}
