package dataStructure.list.review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<E> implements Iterable<E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void addFirst(E e) {
        if (first == null) {
            Node<E> nNode = new Node<>(null, e, null);
            first = nNode;
            last = nNode;
        } else {
            Node<E> n = first;
            first = new Node<>(null, e, n);
            n.prev = first;
        }

        size++;
    }
    
    public void add(E e) {
        addLast(e);
    }

    public void addLast(E e) {
        if (last == null) {
            Node<E> nNode = new Node<>(null, e, null);
            first = nNode;
            last = nNode;
        } else {
            Node<E> l = new Node<>(last, e, null);
            last.next = l;
            last = l;
        }

        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int i;
        Node<E> e;
        if (index < size >> 1) {
            e = first;

            for (i = 0; i < index; i++)
                e = e.next;

        } else {
            e = last;

            for (i = size - 1; i > index; i--)
                e = e.prev;

        }
        return e.data;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();
        if (first != null) {
            Node<E> f = this.first;
            list.add(f.data);
            while (f.next != null) {
                list.add(f.next.data);
                f = f.next;
            }
        }

        return list.iterator();
    }

    private static final class Node<E> {
        Node<E> prev;
        E data;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
