package algorithms.codingtest.sixshop;

import java.util.Stack;

public class SixShop2 {
    static String[] braces(String[] values) {
        String[] ans = new String[values.length];
        for(int i=0; i<ans.length; i++) {
            ans[i] = isValid(values[i]);
        }
        return ans;
    }
    static String isValid(String str) {

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<str.length(); i++) {
            char ch = '1';
            switch(str.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(str.charAt(i));
                    break;
                case ')':
                    if(stack.isEmpty()) {
                        return "NO";
                    } else {
                        ch = stack.pop();
                        if(ch!='(') return "NO";
                        break;
                    }
                case '}':
                    if(stack.isEmpty()) {
                        return "NO";
                    } else {
                        ch = stack.pop();
                        if(ch!='{') return "NO";
                        break;
                    }
                case ']':
                    if(stack.isEmpty()) {
                        return "NO";
                    } else {
                        ch = stack.pop();
                        if(ch!='[') return "NO";
                        break;
                    }
            }
        }

        if(stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args){
        String[] values = new String[4];
        String case1 = "{}()[]";
        String case2 = "{[}]}";
        String case3 = "{{{{";
        String case4 = "{{{{[]()}}}}";
        values[0] = case1;
        values[1] = case2;
        values[2] = case3;
        values[3] = case4;
        String[] results = braces(values);
        for(String s : results){
            System.out.println(s);
        }
    }
}
