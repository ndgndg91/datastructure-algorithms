package algorithms.programers.greedy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        String solution = solution(number, k);
        System.out.println(solution.equals(result));
        System.out.println(solution);
    }

    private static String solution(String number, int k) {
        Set<Long> bowl = new HashSet<>();
        while (k != 0) {
            for (int i = 0; i < number.length(); i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < number.length(); j++) {
                    if (i == j)
                        continue;
                    temp.append(number.charAt(j));
                }

                long max = Long.parseLong(temp.toString());
                bowl.add(max);
            }

            number = String.valueOf(Collections.max(bowl));
            bowl.clear();
            k--;
        }

        return number;
    }

}
