package algorithms.codingtest.crema;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



public class Crema3 {
    /*
     * Complete the 'prefixToPostfix' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY prefixes as parameter.
     */
    public static List<String> prefixToPostfix(List<String> prefixes) {
        // Write your code here
        ArrayList<String> list = new ArrayList<>();
        Stack<String> s = new Stack<>();
        for (String prefix : prefixes) {
            // length of expression
            int length = prefix.length();

            // reading from right to left
            for (int i = length - 1; i >= 0; i--) {

                // check if symbol is operator
                if (isOperator(prefix.charAt(i))) {

                    // pop two operands from stack
                    String op1 = s.peek();
                    s.pop();
                    String op2 = s.peek();
                    s.pop();

                    // concat the operands and operator
                    String temp = op1 + op2 + prefix.charAt(i);

                    // Push string temp back to stack
                    s.push(temp);
                }

                // if symbol is an operand
                else {

                    // push the operand to the stack
                    s.push(""+prefix.charAt(i));
                }
            }

            // stack contains only the Postfix expression
            list.add(s.peek());
            s.clear();
        }
        return list;
    }
    static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int prefixesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> prefixes = IntStream.range(0, prefixesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = prefixToPostfix(prefixes);
        for (String s : result) {
            System.out.println(s);
        }

        bufferedReader.close();
    }
}
