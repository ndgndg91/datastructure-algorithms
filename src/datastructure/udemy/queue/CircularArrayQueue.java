package datastructure.udemy.queue;

public class CircularArrayQueue {
    private int[] queue;
    private int front;
    private int back;
    private int size;

    public CircularArrayQueue(final int capacity) {
        this.queue = new int[capacity];
    }

    public void add(final int value) {
        if (size == queue.length) {
            expand();
        }

        if (back == queue.length) {
            back = 0;
        }

        queue[back++] = value;
        size++;
    }

    private void expand() {
        var newQueue = new int[queue.length * 2];
        var newIndex = 0;
        for (var i = front; i < queue.length; i++) {
            newQueue[newIndex++] = queue[i];
        }

        for (var i = back - front; i < back; i++ ) {
            newQueue[newIndex++] = queue[i];
        }

        front = 0;
        back = queue.length;
        queue = newQueue;
    }

    public int size() {
        return size;
    }

    public int poll() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        if (front == queue.length) {
            front = 0;
        }

        size--;
        var value = queue[front];
        queue[front++] = 0;
        return value;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
