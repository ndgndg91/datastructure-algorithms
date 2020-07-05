package dataStructure;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStackGeneric<T> {
    private T[] stack;
    private int maxSize;
    private int current;
    private int elementsCnt;
    private static final int size = 10;

    public MyStackGeneric() {
        this.stack = (T[]) Array.newInstance(Object.class, size);
        this.current = 0;
        this.elementsCnt = 0;
        this.maxSize = size;
    }

    private void push(T element) {
        if (current == maxSize) {
            T[] temp = (T[]) Array.newInstance(this.stack.getClass(), maxSize+size);
            System.arraycopy(this.stack, 0, temp, 0, current);
            this.stack = temp;
        }
        this.stack[current++] = element;
        elementsCnt++;
    }

    private T pop(){
        if (this.isEmpty())
            throw new EmptyStackException();
        T element = this.stack[current - 1];
        this.stack[current - 1] = null;
        current--;
        elementsCnt--;
        return element;
    }

    private T peek() {
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
        Stack<String> stack = new Stack<>();
        MyStackGeneric<String> strStack =  new MyStackGeneric<>();
        strStack.push("남동길");
        strStack.push("작동하나요?");
        strStack.push("제대로");
        strStack.realArrayPrint();
        strStack.print();
        System.out.println(strStack.isEmpty());

        while (!strStack.isEmpty()){
            System.out.println(strStack.pop());
        }

        MyStackGeneric<Person> perStack = new MyStackGeneric<>();
        System.out.println(perStack.isEmpty());
        perStack.push(new Person("남동길", 29));
        perStack.push(new Person("김영현", 29));
        perStack.push(new Person("최호욱", 28));
        perStack.push(new Person("오홍근", 28));
        perStack.push(new Person("이희범", 28));
        perStack.push(new Person("송윤호", 27));
        perStack.push(new Person("조성웅", 27));
        perStack.push(new Person("박현우", 27));
        perStack.print();
        perStack.realArrayPrint();

        while (!perStack.isEmpty()){
            System.out.println(perStack.pop());
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
