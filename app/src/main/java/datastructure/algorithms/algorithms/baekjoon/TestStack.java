package datastructure.algorithms.algorithms.baekjoon;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        if (stack.search(3) == 1){
            System.out.println("3이 stack 안에 있습니다.");
        }else{
            System.out.println("3이 stack 안에 없습니다");
        }
        if (stack.search(4) == 1){
            System.out.println("4이 stack 안에 있습니다.");
        }else{
            System.out.println("4이 stack 안에 없습니다");
        }
        System.out.println(stack.capacity());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        System.out.println(stack.capacity());

    }
}
