package dataStructure;


import java.util.EmptyStackException;

public class MyStack {
    private int[] stack;
    private int maxSize;
    private int current;
    private int elementsCnt;
    private static final int size = 10;

    public MyStack() {
        this.stack = new int[size];
        this.current = 0;
        this.elementsCnt = 0;
        this.maxSize = size;
    }

    private void push(int element) {
        if (current == maxSize) {
            int[] temp = new int[maxSize + size];
            System.arraycopy(this.stack, 0, temp, 0, current);
            this.stack = temp;
        }
        this.stack[current++] = element;
        elementsCnt++;
    }

    private int pop() {
        if (this.isEmpty())
            throw new EmptyStackException();
        int element = this.stack[current - 1];
        this.stack[current - 1] = 0;
        current--;
        elementsCnt--;
        return element;
    }

    private int peek() {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.stack[current - 1];
    }

    private boolean isEmpty() {
        return current == 0;
    }

    private void print() {
        if (elementsCnt == 0)
            return;
        else
            for (int i = current - 1; i > -1; i--) {
                System.out.print(stack[i] + " ");
            }
        System.out.println();
    }

    private void realArrayPrint() {
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    private int getCurrent(){
        return this.current;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        System.out.println(myStack.isEmpty());
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        System.out.println(myStack.getCurrent());
        myStack.print();
        myStack.realArrayPrint();
        myStack.push(60);
        myStack.push(70);
        myStack.push(80);
        myStack.push(90);
        myStack.push(100);
        myStack.push(110);
        myStack.print();
        myStack.realArrayPrint();
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
    }
}
