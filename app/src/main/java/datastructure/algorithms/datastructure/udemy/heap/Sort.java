package datastructure.algorithms.datastructure.udemy.heap;

/**
 * We know the root has the largest value
 * swap root with last element int the array
 * heappify the tree, but exclude the last node
 * after heapfify, second largest element is at the root
 * rinse and repeat
 */
public class Sort {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(90);
        heap.insert(5);
        heap.insert(25);
        heap.insert(10);
        heap.insert(56);
        heap.insert(68);
        heap.insert(75);

        heap.printHeap();
        heap.sort();
        heap.printHeap();
    }
}
