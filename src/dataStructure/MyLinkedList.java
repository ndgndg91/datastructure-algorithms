package dataStructure;


import java.util.*;

public class MyLinkedList implements Iterable {
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public Iterator iterator() {
        List<Node> list = new ArrayList<>();
        if (this.head != null) {
            Node x = this.head;
            list.add(x);
            for (int i = 1; i < this.size; i++) {
                x = x.next;
                list.add(x);
            }
        }
        return list.iterator();
    }

    private static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
        if (this.head.next == null)
            this.tail = this.head;

    }

    public void add(Object data) {
        if (this.size == 0) {
            this.addFirst(data);
        } else {
            Node newNode = new Node(data);
            this.tail.next = newNode;
            this.tail = newNode;
            size++;
        }
    }

    public void add(int idx, Object data) {
        if (idx < 0) throw new NegativeArraySizeException("Index: " + idx);
        if (idx > this.size) throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
        Node newNode = new Node(data);
        if (idx == 0) {
            this.addFirst(data);
        } else {
            Node beforeNewNode = this.get(idx - 1);
            Node afterNewNode = beforeNewNode.next;
            beforeNewNode.next = newNode;
            this.size++;
            if (afterNewNode == null)
                this.tail = newNode;
            else
                newNode.next = afterNewNode;
        }
    }

    public void addLast(Object data) {
        if (this.size == 0)
            this.addFirst(data);
        else {
            Node newNode = new Node(data);
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }

    public Object remove() {
        if (this.size == 0) throw new NoSuchElementException();
        Node returnHead = this.head;
        Node willBeHead = this.head.next;
        Node willBeSecond = willBeHead.next;
        this.head = null;
        this.head = willBeHead;
        willBeHead.next = willBeSecond;
        this.size--;
        if (this.size == 1)
            this.tail = this.head;
        return returnHead;
    }

    public void remove(int idx) {
        if (idx < 0) throw new NegativeArraySizeException("Index: " + idx);
        if (this.size == 0) throw new NoSuchElementException();
        if (idx == 0)
            removeFirst();
        else {
            Node willBeRemoved = this.get(idx);
            Node after = willBeRemoved.next;
            Node before = this.get(idx - 1);
            before.next = after;
            this.size--;
            if (this.size == 1)
                this.tail = this.head;
        }
    }

    public void remove(Object data) {
        int untilToSize = -1;
        int escapeCondition = this.size-1;
        while (untilToSize++ < escapeCondition){
            if(this.get(untilToSize).data.equals(data)){
                remove(untilToSize);
                untilToSize = 0;
                escapeCondition = this.size-1;
            }
        }
    }

    public void removeFirst() {
        if (this.size == 0) throw new NoSuchElementException();
        this.head = this.head.next;
        this.size--;
        if (this.size == 1)
            this.tail = this.head;
    }

    public void removeLast() {
        if (this.size == 0) throw new NoSuchElementException();
        if (this.size < 2)
            this.clear();
        else {
            this.tail = this.get(this.size - 2);
            this.size--;
        }
    }

    public Node get(int idx) {
        if (idx < 0) throw new NegativeArraySizeException("Index: " + idx);
        if (idx >= this.size) throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
        Node x = this.head;
        for (int i = 0; i < idx; i++)
            x = x.next;
        return x;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(15);
        myLinkedList.addFirst(10);
        myLinkedList.add(50);
        myLinkedList.add(70);
        myLinkedList.addLast(100);
        myLinkedList.add(0, 0);
        myLinkedList.addFirst(10);
        myLinkedList.addLast(10);
        System.out.println();
        for (Object i : myLinkedList) {
            System.out.println(i);
        }
        myLinkedList.remove(new Integer(10));
        System.out.println("After : remove(new Integer(10)) Method");
        for (Object i : myLinkedList) {
            System.out.println(i);
        }

    }
}
