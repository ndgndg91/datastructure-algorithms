package datastructure.list.udemy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackDriver {

    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();

        stack.push("남동길");
        stack.push("아무개");
        stack.push("김영희");

        System.out.println(stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
