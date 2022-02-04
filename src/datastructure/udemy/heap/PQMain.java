package datastructure.udemy.heap;

import java.util.PriorityQueue;

public class PQMain {

    public static void main(String[] args) {
        // the lower number is, the more priority is.
        // so, priority queue is min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-25);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

        System.out.println();
        Object[] ints = pq.toArray();
        for (var num : ints) {
            System.out.println(num);
        }
    }
}

/**
 *                  90
 *                5    25
 *              10 56 68 75
 */
