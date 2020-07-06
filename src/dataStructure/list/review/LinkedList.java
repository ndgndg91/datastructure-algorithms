package dataStructure.list.review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private long size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void linkTail(T e){
        Node<T> t = this.tail;
        Node<T> newNode = new Node<>(t, e, null);

        if (t == null) {
            this.head = newNode;
        } else {
            t.next = newNode;
        }

        this.size++;
    }

    private void linkHead(T e) {
        Node<T> h = this.head;
        Node<T> newNode = new Node<>(null, e, h);

        if (h == null) {
            this.head = newNode;
        } else {
            h.prev = newNode;
        }

        this.size++;
    }

    public boolean add(T e) {
        linkHead(e);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        List<T> list = new ArrayList<>();
        if (this.head != null) {
            Node<T> x = this.head;
            list.add(x.data);
            for (int i = 1; i < this.size; i++) {
                x = x.next;
                T d = x.data;
                list.add(d);
            }
        }

        return list.iterator();
    }

    private static final class Node<T> {
        Node<T> prev;
        T data;
        Node<T> next;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
