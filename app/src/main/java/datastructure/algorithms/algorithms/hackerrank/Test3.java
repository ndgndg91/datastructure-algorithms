package datastructure.algorithms.algorithms.hackerrank;

public class Test3 {

    public static void main(String[] args) {
        String testCase1 = "()()";
        String testCase2 = "(())()";
        String testCase3 = ")()(";
        String testCase4 = "(()(";
        boolean result1 = solution(testCase1);
        boolean result2 = solution(testCase2);
//        boolean result3 = solution(testCase3);
        boolean result4 = solution(testCase4);
        System.out.println("testCase 1 : " + result1);
        System.out.println("testCase 2 : " + result2);
//        System.out.println("testCase 3 : " +result3);
        System.out.println("testCase 4 : " + result4);
    }

    private static boolean solution(String s) {
        int bracket = 0;
        for (int i = 0; i < s.length(); i++){
            if (bracket < 0)
                return false;
            if(s.charAt(i) == '(')
                bracket++;
            if(s.charAt(i) == ')')
                bracket--;
        }
        if(bracket != 0)
            return false;
        return true;
    }
}
