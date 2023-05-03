package datastructure.algorithms.datastructure.udemy.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularArrayQueueTest {

    @Test
    void add() {
        final var circularQueue = new CircularArrayQueue(3);
        circularQueue.add(100);
        circularQueue.add(500);
        circularQueue.add(1000);

        assertEquals(3, circularQueue.size());
    }

    @Test
    void addMoreThanCapacity() {
        final var circularQueue = new CircularArrayQueue(3);
        circularQueue.add(1000);
        circularQueue.add(2000);
        circularQueue.add(3000);
        circularQueue.add(4000);

        assertEquals(4, circularQueue.size());
    }

    @Test
    void peek() {
        final var circularQueue = new CircularArrayQueue(5);
        circularQueue.add(500);
        circularQueue.add(10);
        circularQueue.add(100);

        assertEquals(500, circularQueue.peek());
    }

    @Test
    void poll() {
        final var circularQueue = new CircularArrayQueue(5);
        circularQueue.add(0);
        circularQueue.add(50);
        circularQueue.add(-50);

        assertFalse(circularQueue.isEmpty());
        assertEquals(3, circularQueue.size());
        assertEquals(0, circularQueue.poll());
        assertEquals(50, circularQueue.peek());
        assertEquals(50, circularQueue.poll());
        assertEquals(-50, circularQueue.peek());
        assertEquals(1, circularQueue.size());
        assertEquals(-50, circularQueue.poll());
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    void integration() {
        final var circularQueue = new CircularArrayQueue(5);
        circularQueue.add(100);
        circularQueue.add(300);
        circularQueue.add(500);

        while (!circularQueue.isEmpty()) {
            System.out.println(circularQueue.poll());
        }

        circularQueue.add(200);
        circularQueue.add(400);
        circularQueue.add(1000);
        circularQueue.add(900);
        circularQueue.add(2000);

        assertEquals(5, circularQueue.size());

        circularQueue.add(5000);

        circularQueue.add(10000);
        circularQueue.add(20000);
    }

    @Test
    void integration2() {
        final var circularQueue = new CircularArrayQueue(3);
        circularQueue.add(100);
        circularQueue.add(200);

        assertEquals(circularQueue.poll(), 100);

        circularQueue.add(300);
        circularQueue.add(400);

        assertEquals(circularQueue.poll(), 200);
        assertEquals(circularQueue.poll(), 300);
        assertEquals(circularQueue.poll(), 400);

        circularQueue.add(500);
        circularQueue.add(600);
        circularQueue.add(700);

        assertEquals(circularQueue.poll(), 500);
        assertEquals(circularQueue.poll(), 600);
        assertEquals(circularQueue.poll(), 700);

        circularQueue.add(800);

        assertEquals(circularQueue.poll(), 800);

        circularQueue.add(900);
        circularQueue.add(1000);

        assertEquals(circularQueue.poll(), 900);
        assertEquals(circularQueue.poll(), 1000);

        circularQueue.add(2000);
        circularQueue.add(3000);
        circularQueue.add(4000);
        circularQueue.add(5000);

        assertEquals(circularQueue.poll(), 2000);
        assertEquals(circularQueue.poll(), 3000);
        assertEquals(circularQueue.poll(), 4000);
        assertEquals(circularQueue.poll(), 5000);

    }

}