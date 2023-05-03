package datastructure.algorithms.algorithms.programers.test;

public class Test {

    private static final String first = "xyZA";
    private static final String second = "ABCxy";
    private static final String answer = "ABCxyZA";

    private static final String first2 = "AxA";
    private static final String second2 = "AyA";
    private static final String answer2 = "AxAyA";

    private static final String first3 = "aBxYAz";
    private static final String second3 = "zAYxBa";
    private static final  String answer3 = "aBxYAzAYxBa";

    public static void main(String[] args){
        String solution = solution(first, second);
        System.out.println(solution);
        System.out.println(solution.equals(answer));

        String solution1 = solution(first2, second2);
        System.out.println(solution1);
        System.out.println(solution1.equals(answer2));

        String solution2 = solution(first3, second3);
        System.out.println(solution2);
        System.out.println(solution2.equals(answer3));

    }

    private static String solution(String s1, String s2) {
        int s1Cnt = count(s1, s2);
        int s2Cnt = count(s2, s1);
        System.out.println(s1Cnt);
        System.out.println(s2Cnt);

        String candidate1 = s1.substring(0, s1.length() - s1Cnt) + s2;
        String candidate2 = s2.substring(0, s2.length() - s2Cnt) + s1;

        System.out.println(candidate1);
        System.out.println(candidate2);
        System.out.println("==================");
        if (candidate1.length() == candidate2.length()) return select(candidate1, candidate2);
        return candidate1.length() < candidate2.length() ? candidate1 : candidate2;
    }

    private static String select(String candidate1, String candidate2) {
        for (int i = 0; i < candidate1.length(); i++) {
            if (candidate1.charAt(i) < candidate2.charAt(i)) return candidate1;
            if (candidate1.charAt(i) > candidate2.charAt(i)) return candidate2;
        }
        return "";
    }

    private static int count(String s1, String s2) {
        int count = 0;
        int s2TokenCnt = 1;
        for (int i = s1.length() - 1; i >= 0; i--) {
            String extract = extract(s2, s2TokenCnt);
            s2TokenCnt++;
            String substring = s1.substring(i);
            if (substring.equals(extract)) count = substring.length();
        }

        return count;
    }

    private static String extract(String s2, int idx) {
        try {
            return s2.substring(0, idx);
        } catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }

}
