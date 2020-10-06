package self.braket;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem {
    private static final String CASE1 = "{}()[]";
    private static final String CASE2 = "{[}]}";
    private static final String CASE3 = "{{{{";
    private static final String CASE4 = "{{{{[]()}}}}";

    public static void main(String[] args) {
        System.out.println("CASE1 is valid : " + isValid(CASE1));
        System.out.println("CASE1 is valid : " + isValid(CASE2));
        System.out.println("CASE1 is valid : " + isValid(CASE3));
        System.out.println("CASE1 is valid : " + isValid(CASE4));
    }

    private static boolean isValid(String testCase) {
        Deque<String> stack = new ArrayDeque<>();

        String[] tokens = split(testCase);
        for (String token : tokens) {

            if (Type.isLeft(token))
                stack.push(token);
            else if (!stack.isEmpty() && Type.isRight(token)) {
                String left = stack.pop();
                boolean rightPartner = Type.isRightPartner(left, token);
                if (!rightPartner) return false;
            }

        }

        return stack.isEmpty();
    }

    private static String[] split(String str) {
        return str.split("");
    }

    private enum Type {
        L_1("{", "}"),
        L_2("(", ")"),
        L_3("[", "]"),

        R_1("}", "{"),
        R_2(")", "("),
        R_3("]", "]");

        Type(String val, String rightPartner) {
            this.val = val;
            this.rightPartner = rightPartner;
        }

        private final String val;
        private final String rightPartner;

        public static boolean isLeft(String target){
            return target.equals(L_1.val) || target.equals(L_2.val) || target.equals(L_3.val);
        }

        public static boolean isRight(String target) {
            return target.equals(R_1.val) || target.equals(R_2.val) || target.equals(R_3.val);
        }

        public static boolean isRightPartner(String left, String right) {
            Type type = Arrays.stream(Type.values()).filter(t -> t.val.equals(left)).findAny().orElseThrow();
            return type.rightPartner.equals(right);
        }
    }
}
