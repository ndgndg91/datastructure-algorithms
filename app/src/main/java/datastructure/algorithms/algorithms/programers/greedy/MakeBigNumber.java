package datastructure.algorithms.algorithms.programers.greedy;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MakeBigNumber {
    private static final String number = "1924";
    private static final int k = 2;
    private static final int result = 94;

    private static final String number2 = "1231234";
    private static final int k2 = 3;
    private static final int result2 = 3234;

    private static final String number3 = "4177252841";
    private static final int k3 = 4;
    private static final int result3 = 775841;

    private static final String number4 = "99881";
    private static final int k4 = 2;
    private static final int result4 = 998;

    public static void main(String[] args) {
        String solution = solution(number4, k4);
        System.out.println(solution);
    }

    private static String solution(String number, int k) {
        StringBuilder result = new StringBuilder();

        Deque<Character> stack = new LinkedList<>();
        int resultLength = number.length() - k;

        while (k > 0) {
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                if (k == 0) {
                    stack.push(c);
                    continue;
                }

                while (!stack.isEmpty() && stack.peek() < c) {
                    stack.pop();
                    k--;
                    if (k == 0) break;
                }

                stack.push(c);
            }

            while (stack.size() > resultLength) {
                stack.pop();
                k--;
            }
        }

        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

}
